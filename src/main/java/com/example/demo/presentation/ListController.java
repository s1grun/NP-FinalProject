package com.example.demo.presentation;

import com.example.demo.application.ListItemService;
import com.example.demo.application.ListService;
import com.example.demo.application.LocationService;
import com.example.demo.application.UserService;
import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListItemDTO;
import com.example.demo.domain.ListitemEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@RestController
public class ListController {
    @Autowired
    private UserService userService;
    @Autowired
    private ListService listService;
    @Autowired
    private ListItemService listItemService;
    @Autowired
    private LocationService locationService;

    @RequestMapping("/lists")
    public String getLists(@RequestParam("owner") String ownerid) {
       List<? extends ListDTO> allLists = listService.getAllLists(ownerid);

       JSONArray lists_res = new JSONArray();

       for (int i = 0; i < allLists.size(); i++) {
           ListDTO item= allLists.get(i);
//           System.out.println(item.toString());
           JSONObject temp = new JSONObject(item);
//           System.out.println(temp.toString());
           List<? extends ListItemDTO> res =listItemService.getListItemDTOByListid(item.getListid());
           temp.put("items",res);
           lists_res.put(temp);
       }
       JSONObject res = new JSONObject();
       res.put("data",lists_res);
       res.put("status",200);
       res.put("locations",locationService.getAllLocations());
       return  res.toString();

    }

    @RequestMapping(value = "/addList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newList(@RequestBody ListsModel listsModel) throws URISyntaxException {
        String listname = listsModel.getListname();
        String owner = listsModel.getOwner();

        ListDTO alist = listService.getByNameAndOwner(listname,owner);
        if (alist ==null||(alist!=null&&(!alist.getOwner().equals(owner)))){
            listService.createList(listname, owner);

            JSONObject temp = new JSONObject();
            temp.put("listname", listname);
            temp.put("listid", alist.getListid());
            temp.put("status", 200);
            return temp.toString();
        }else{
            JSONObject temp = new JSONObject();
            temp.put("status", 500);
            return temp.toString();
        }

    }

//    @RequestMapping(value = "/deleteList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public String deleteList(@RequestBody ListitemModel listitemModel) throws URISyntaxException {
////        System.out.println(listitemModel.getItemid());
//        int itemid = listitemModel.getItemid();
//        ListItemDTO listItemDTO = listItemService.findListitemByItemid(itemid);
//
//        if (listItemDTO != null) {
//            listItemService.deleteListitem(itemid);
//            JSONObject res = new JSONObject();
//            res.put("status",200);
//            res.put("msg","ok");
//            return res.toString();
//        }else{
//            JSONObject res = new JSONObject();
//            res.put("status",500);
//            res.put("msg","No this item");
//            return res.toString();
//        }
//
//    }

//    @RequestMapping(value = "/updateList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public List<ListDTO> editList(@RequestBody ListsModel addLists) throws URISyntaxException {
//        String listsName = addLists.getName();
//        int listid = addLists.getListid();
//        String collaborators = addLists.getCollaborators();
//        ListDTO listDTO = listService.findListById(listid);
//
//        if (listDTO != null) {
//            listDTO.setListname(listsName);
//            listDTO.setCollaborators(collaborators);
//            listService.editList((ListEntity) listDTO);
//        }
//
//        return (List<ListDTO>) listService.getAllLists();
//    }



    @RequestMapping("/listItems")
    public List<ListItemDTO> getListItems() {
        return (List<ListItemDTO>) listItemService.getAllItems();
    }

    @RequestMapping(value = "/addListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newListItem(@RequestBody ListitemModel listitemModel) throws URISyntaxException {
        String content = listitemModel.getContent();
        int listid = listitemModel.getListid();
        String locationid = listitemModel.getLocationid();
        if(listItemService.getListItemDTOByContent(content) == null) {
            listItemService.createListitem(content, listid, locationid);
            List<? extends ListItemDTO> listitems = listItemService.getListItemDTOByListid(listid);
            JSONObject temp = new JSONObject();
            temp.put("data", listitems);
            temp.put("status", 200);
            if(locationid!=""&&locationService.getLocationbyId(locationid)==null){
                JSONObject details = getLocationDetail(locationid);
                if(details!=null && !details.has("error_message")){
                    JSONObject result = (JSONObject) details.get("result");
                    JSONObject geometry = (JSONObject) result.get("geometry");
                    String formatted_address =  result.getString("formatted_address");
                    String coord =  geometry.get("location").toString();
                    locationService.newLocation(locationid,formatted_address,coord);
                }else{
                    temp.put("status", 201);
                }
            }
            temp.put("locations",locationService.getAllLocations());
            return temp.toString();
        }else{
            JSONObject temp = new JSONObject();
            temp.put("status", 500);
            temp.put("data", "this content already exists");
            return temp.toString();
        }

    }

    public JSONObject getLocationDetail(String place_id){
        try {
            String msg ="";
            String str = "https://maps.googleapis.com/maps/api/place/details/json?place_id="+place_id+"&fields=name,formatted_address,place_id,geometry&key=AIzaSyCP9q-M75_Wf5mvA1n6ZSevt7qskz83_mo";
            URL url = new URL(str);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode =  connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream inStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    msg+=line;
                }
                System.out.println(msg);
                bufferedReader.close();
                connection.disconnect();
            }
            return new JSONObject(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @RequestMapping(value = "/updateListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateListItem(@RequestBody ListitemModel listitemModel) throws URISyntaxException {
        String content = listitemModel.getContent();
        int itemid = listitemModel.getItemid();
        int status = listitemModel.getStatus();
//        String assignee = listitemModel.getAssignee();
        String locationid = listitemModel.getLocationid();
        ListItemDTO listItemDTO = listItemService.findListitemByItemid(itemid);

        if (listItemDTO != null) {
            listItemDTO.setContent(content);
            listItemDTO.setStatus(status);
            listItemDTO.setLocationid(locationid);
            listItemService.editListitem((ListitemEntity) listItemDTO);

            int listid = listItemDTO.getListid();
            List<? extends ListItemDTO> listitems = listItemService.getListItemDTOByListid(listid);
            JSONObject res = new JSONObject();
            res.put("data",listitems);
            res.put("listid",listid);
            res.put("status",200);
            if(locationid!=""&&locationService.getLocationbyId(locationid)==null){
                JSONObject details = getLocationDetail(locationid);
                if(details!=null && !details.has("error_message")){
                    JSONObject result = (JSONObject) details.get("result");
                    JSONObject geometry = (JSONObject) result.get("geometry");
                    String formatted_address =  result.getString("formatted_address");
                    String coord =  geometry.get("location").toString();
                    locationService.newLocation(locationid,formatted_address,coord);
                }else{
                    res.put("status", 201);
                }
            }
            res.put("locations",locationService.getAllLocations());
            return res.toString();
        }else{
            JSONObject res = new JSONObject();
            res.put("status",500);
            res.put("msg","No this item");
            return res.toString();
        }

    }

    @RequestMapping(value = "/deleteListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteListItem(@RequestBody ListitemModel listitemModel) throws URISyntaxException {
//        System.out.println(listitemModel.getItemid());
        int itemid = listitemModel.getItemid();
        ListItemDTO listItemDTO = listItemService.findListitemByItemid(itemid);

        if (listItemDTO != null) {
            listItemService.deleteListitem(itemid);
            JSONObject res = new JSONObject();
            res.put("status",200);
            res.put("msg","ok");
            return res.toString();
        }else{
            JSONObject res = new JSONObject();
            res.put("status",500);
            res.put("msg","No this item");
            return res.toString();
        }

    }

//    public boolean validateToken(String token) {
//        //System.out.println(token);
//        if (token == null) {
//            return false;
//        }
//
//        try {
//            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
//            if (Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject().equals("john")) {
//                String str = body.toLowerCase();
//                Message res = game.guess(str);
//                Message.sendMsg(output, res);
//                if (res.getType().equals("finish")) {
//                    this.score = Integer.valueOf(res.getBody());
//                    Message start_msg = new Message("update", game.getUnderline() + "," + Integer.toString(game.getCounter()) + "," + Integer.toString(game.getScore()));
//                    Message.sendMsg(output, start_msg);
//                }
//            } else {
//                Message start_msg = new Message("login", "user is not authenticated");
//                Message.sendMsg(output, start_msg);
//            }
//        } catch (JwtException e) {
//            Message start_msg = new Message("login", "user is not authenticated");
//            Message.sendMsg(output, start_msg);
//        }
//    }
}
