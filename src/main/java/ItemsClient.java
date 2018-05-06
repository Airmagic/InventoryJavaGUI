import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Arrays;


// base programming from Clara James


public class ItemsClient {
    //    This is where the json file is located
    private static final String URL = "http://127.0.0.1:5000/";   // Replace with your own URL, if different

    //    This is getting all Items in the jcson file
    public static void getAllItems(ItemsGUI gui) {

//        this is checking if it can get the infor and responding back
        Unirest.get(URL + "items")
                .header("Content-Type", "application/json")
                .asObjectAsync(Item[].class, new Callback<Item[]>() {

                    //                   This is when there is a responce from the storage
                    @Override
                    public void completed(HttpResponse<Item[]> httpResponse) {
                        System.out.println("all items response " + Arrays.toString(httpResponse.getBody()));
                        gui.newItemList(httpResponse.getBody());
                    }

                    //                    This is when no responce from the storage
                    @Override
                    public void failed(UnirestException e) {
                        System.out.println(e);
                        gui.itemError(e);

                    }

                    @Override
                    public void cancelled() {
                        System.out.println("cancelled");
                    }
                });

    }


    //    This is for adding a new item to the storage
    public static void addItem(NewOrUpdateItem gui, Item item) {

        Unirest.post(URL + "item/add")
                .header("Content-Type", "application/json")
                .body(item)
                .asJsonAsync(new Callback<JsonNode>() {
                    @Override
                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        System.out.println("add response " + httpResponse.getStatus()); // hopefully 201, should check
//                        gui.itemsUpdated();

                    }

                    //                    This is the responces if it can't store the new item
                    @Override
                    public void failed(UnirestException e) {
                        System.out.println("Add item " + e);
                        gui.itemError(e);

                    }


                    @Override
                    public void cancelled() {
                        System.out.println("Cancelled");
                    }
                });
    }

    //    This is for getting one item to update
    public static void getOneItem(ItemsGUI gui, Item item) {
        System.out.println("one item retrieve");

        Unirest.patch(URL + "item/getOneItem")
                .header("Content-Type", "application/json")
                .body(item)
                .asJsonAsync(new Callback<JsonNode>() {
                    @Override
                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        System.out.println("One Item response " + httpResponse.getStatus()); // hopefully 201, should check
                        gui.itemsUpdated();

                    }

                    @Override
                    public void failed(UnirestException e) {
                        System.out.println("One Item " + e);
                        gui.itemError(e);

                    }

                    @Override
                    public void cancelled() {
                        System.out.println("One Item cancelled");
                    }
                });
    }

    //    This is for getting one item to update
    public static void getOneItem(NewOrUpdateItem gui, Item item) {
        System.out.println("one item retrieve");

        Unirest.patch(URL + "item/getOneItem")
                .header("Content-Type", "application/json")
                .body(item)
                .asJsonAsync(new Callback<JsonNode>() {
                    @Override
                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        System.out.println("One Item response " + httpResponse.getStatus()); // hopefully 201, should check
//                        gui.itemsUpdated();

                    }

                    @Override
                    public void failed(UnirestException e) {
                        System.out.println("One Item " + e);
                        gui.itemError(e);

                    }

                    @Override
                    public void cancelled() {
                        System.out.println("One Item cancelled");
                    }
                });
    }

    //    This is for updating an Item
    public static void updateItem(ItemsGUI gui, Item item) {
        System.out.println("Update - Implement me!");

        Unirest.patch(URL + "item/update")
                .header("Content-Type", "application/json")
                .body(item)
                .asJsonAsync(new Callback<JsonNode>() {
                    @Override
                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        System.out.println("Updated response " + httpResponse.getStatus()); // hopefully 201, should check
                        gui.itemsUpdated();

                    }

                    @Override
                    public void failed(UnirestException e) {
                        System.out.println("update  " + e);
                        gui.itemError(e);

                    }

                    @Override
                    public void cancelled() {
                        System.out.println("Completed cancelled");
                    }
                });
    }

//    This is for deleting an item
    public static void deleteItem(ItemsGUI gui, Item item) {
        System.out.println("Delete - implement me!");

        Unirest.delete(URL + "item/delete")
                .header("Content-Type", "application/json")
                .body(item)
                .asJsonAsync(new Callback<JsonNode>() {
                    @Override
                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        System.out.println("Deleted response " + httpResponse.getStatus()); // hopefully 201, should check
                        gui.itemsUpdated();
                    }

                    @Override
                    public void failed(UnirestException e) {
                        System.err.println("delete " + e);
                        gui.itemError(e);
                    }

                    @Override
                    public void cancelled() {
                        System.out.println("Delete cancelled");
                    }
                });
    }


    }
