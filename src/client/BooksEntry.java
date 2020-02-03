package client;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.*;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.xhr.client.XMLHttpRequest;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import static com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.*;


public class BooksEntry implements EntryPoint {

    public static final String HEADER = "content-type";
    public static final String HEADER_VALUE = "application/json";

    private List<Books> books = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<Purchase>();

    private final MenuBar menu = new MenuBar();
    private final HorizontalPanel bookBtnPanel = new HorizontalPanel();
    private final HorizontalPanel purchaseBtnPanel = new HorizontalPanel();

    private final Button addBookButton = new Button();
    private final Button addPurchaseButton = new Button();
    private final Button editBookButton = new Button();
    private final Button editPurchaseButton = new Button();
    private final Button deleteBookButton = new Button();
    private final Button deletePurchaseButton = new Button();

    private final VerticalPanel vp = new VerticalPanel();
    private final VerticalPanel vpPurchase = new VerticalPanel();

    private final HorizontalPanel boxPanel = new HorizontalPanel();
    private final HorizontalPanel boxPurchasePanel = new HorizontalPanel();

    private final TextBox idBox = new TextBox();
    private final TextBox nameBox = new TextBox();
    private final TextBox costBox = new TextBox();
    private final TextBox warehouseBox = new TextBox();
    private final TextBox quantityBox = new TextBox();
    private final CellTable<Books> cellTableOfBooks = new CellTable<>();
    private final DataGrid<Purchase> cellTableOfPurchase = new DataGrid();

    private final ListDataProvider<Purchase> listDataProvider = new ListDataProvider<>();

/*new Purchase(123, 264562, new Date(02022020l),
            new Shop(123, "TEST", "TESTAREA", 99.9),
            new Buyer(123, "test", "testarea", 88.8), 9, 1000.0,
            new Books(123, "test", 1000.0, "test", 9))*/


    public void onModuleLoad() {

        Command cmd = () -> Window.alert("You selected a menu item!");



        menu.addItem("books", (Command) () -> {
            vp.setVisible(true);
            bookBtnPanel.setVisible(true);
            boxPanel.setVisible(true);
            purchaseBtnPanel.setVisible(false);
            vpPurchase.setVisible(false);
        });
        menu.addItem("purchase", (Command) () -> {
            vp.setVisible(false);
            bookBtnPanel.setVisible(false);
            boxPanel.setVisible(false);
            vpPurchase.setVisible(true);
            cellTableOfPurchase.setVisible(true);
            purchaseBtnPanel.setVisible(true);
        });
        menu.addItem("buyers", cmd);
        menu.addItem("shops", cmd);

        bookBtnPanel.add(addBookButton);
        bookBtnPanel.add(editBookButton);
        bookBtnPanel.add(deleteBookButton);
        addBookButton.setText("Add");
        editBookButton.setText("Edit");
        deleteBookButton.setText("Delete");

        boxPanel.add(idBox);
        boxPanel.add(nameBox);
        boxPanel.add(costBox);
        boxPanel.add(warehouseBox);
        boxPanel.add(quantityBox);
        boxPanel.setWidth("600px");

        addBookButton.setSize("80px", "20px");
        editBookButton.setSize("80px", "20px");
        deleteBookButton.setSize("80px", "20px");
        bookBtnPanel.setSize("300px", "30px");

        idBox.setWidth("50px");
        idBox.setText("id");
        idBox.addClickHandler(event -> idBox.setText(""));
        nameBox.setText("name");
        nameBox.setWidth("200px");
        nameBox.addClickHandler(event -> nameBox.setText(""));
        costBox.setWidth("60px");
        costBox.setText("cost");
        costBox.addClickHandler(event -> costBox.setText(""));
        warehouseBox.setText("warehouse");
        warehouseBox.setWidth("200px");
        warehouseBox.addClickHandler(event -> warehouseBox.setText(""));
        quantityBox.setWidth("54px");
        quantityBox.setText("quantity");
        quantityBox.addClickHandler(event -> quantityBox.setText(""));

        cellTableOfBooks.setWidth("600px");
        cellTableOfBooks.setHeight("600px");


        purchaseBtnPanel.setVisible(false);
        vpPurchase.setVisible(false);
        cellTableOfPurchase.setVisible(false);
        purchaseBtnPanel.add(addPurchaseButton);
        purchaseBtnPanel.add(editPurchaseButton);
        purchaseBtnPanel.add(deletePurchaseButton);
        addPurchaseButton.setText("Add");
        editPurchaseButton.setText("Edit");
        deletePurchaseButton.setText("Delete");

        listDataProvider.addDataDisplay(cellTableOfPurchase);
        listDataProvider.setList(purchases);
        cellTableOfPurchase.setSize("600", "500px");


        SimplePager pager = new SimplePager(SimplePager.TextLocation.CENTER, (SimplePager.Resources) GWT.create(SimplePager.Resources.class), false, 10, true) {
            @Override
            public boolean hasNextPage() {
                if (this.getPage() < (this.getPageCount() - 1)) {
                    return true;
                }
                return false;
            }
        };
//        pager.setDisplay(cellTableOfPurchase);




        vpPurchase.add(cellTableOfPurchase);
//        vpPurchase.add(pager);



        addPurchaseButton.addClickHandler(event -> {
            purchases.add(new Purchase(123, 264562, new Date(20, 11, 5),
                    new Shop(123, "TEST", "TESTAREA", 99.9),
                    new Buyer(123, "test", "testarea", 88.8), 9, 1000.0,
                    new Books(123, "test", 1000.0, "test", 9)));

            cellTableOfPurchase.redraw();
            cellTableOfPurchase.setRowCount(purchases.size(), true);
            cellTableOfPurchase.setRowData(0, purchases);
        });

        editPurchaseButton.addClickHandler(event -> {
            XMLHttpRequest req = XMLHttpRequest.create();
            req.open("GET", "http://localhost:8082/purchase/all", "false");
            req.setOnReadyStateChange(xhr -> {

                if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                    if (xhr.getStatus() == 200) {

                        JSONValue jsonValue = JSONParser.parseLenient(req.getResponseText());
                        JSONArray jsonArray = jsonValue.isArray();
                        purchases.clear();
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject obj = jsonArray.get(i).isObject();
//                            JSONArray shopTmp = obj.get("seller").isArray();
                            JSONArray buyerTmp = obj.get("buyer").isArray();
                            JSONArray bookTmp = obj.get("book").isArray();

                            JSONObject buyerObj = buyerTmp.get(0).isObject();
//                            JSONObject shopObj = shopTmp.get(0).isObject();
                            JSONObject bookObj = bookTmp.get(0).isObject();
                            JSONObject shopOb = obj.get("seller").isObject();

                            Shop shop = new Shop(11,"11", "11", 11.1);
/*                            shop.setId((int)shopOb.get("id").isNumber().doubleValue());
                            shop.setShopName(shopOb.get("shopName").isString().stringValue());
                            shop.setShopLocationArea(shopOb.get("shopLocationArea").isString().stringValue());
                            shop.setCommissionFee(shopOb.get("commissionFee").isNumber().doubleValue());*/
//                            shop.setId((int)shopObj.get("id").isNumber().doubleValue());
//                            shop.setShopName(shopObj.get("shopName").isString().stringValue());
//                            shop.setShopLocationArea(shopObj.get("shopLocationArea").isString().stringValue());
//                            shop.setCommissionFee(shopObj.get("commissionFee").isNumber().doubleValue());

                            Buyer buyer = new Buyer();
                            buyer.setId((int)buyerObj.get("id").isNumber().doubleValue());
                            buyer.setSurname(buyerObj.get("surname").isString().stringValue());
                            buyer.setResidenceArea(buyerObj.get("residenceArea").isString().stringValue());
                            buyer.setDiscount(buyerObj.get("discount").isNumber().doubleValue());


                            Books book = new Books();

                            book.setId(1111);
                            book.setName(bookObj.get("bookName").isString().stringValue());
                            book.setWarehouse(bookObj.get("bookWarehouse").isString().stringValue());
                            book.setCost(bookObj.get("bookCost").isNumber().doubleValue());
                            book.setQuantity((int)bookObj.get("bookQuantity").isNumber().doubleValue());

                            String [] arr = obj.get("date").isString().stringValue().split("-");



                            purchases.add(new Purchase((int)obj.get("id").isNumber().doubleValue(),
                                                        (int)obj.get("orderNumber").isNumber().doubleValue(),
//                                                        new Date(Long.valueOf(obj.get("date").isString().stringValue())),
                                                        new Date(20,11,15),
                                                        shop,buyer,
                                                        (int)obj.get("quantity").isNumber().doubleValue(),
                                                        obj.get("sum").isNumber().doubleValue(),book));

                        }

                        cellTableOfPurchase.redraw();
                        cellTableOfPurchase.setRowCount(books.size(), true);
                        cellTableOfPurchase.setRowData(0, purchases);
                    }
                }
            });
            req.send();
        });



        cellTableOfPurchase.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

        TextColumn<Purchase> columnIdPurchase = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getId());
            }
        };
        cellTableOfPurchase.addColumn(columnIdPurchase, "ID");

        TextColumn<Purchase> columnOrderNumber = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getOrderNumber());
            }
        };
        cellTableOfPurchase.addColumn(columnOrderNumber, "OrderNumber");

        TextColumn<Purchase> columnDate = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getDate());
            }
        };
        cellTableOfPurchase.addColumn(columnDate, "Date");

        TextColumn<Purchase> columnSellerName = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getSeller().getShopName());
            }
        };
        cellTableOfPurchase.addColumn(columnSellerName, "ShopName");

        TextColumn<Purchase> columnSellerLocationArea = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getSeller().getShopLocationArea());
            }
        };
        cellTableOfPurchase.addColumn(columnSellerLocationArea, "ShopLocationArea");

        TextColumn<Purchase> columnSellerCommissionFee = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getSeller().getCommissionFee());
            }
        };
        cellTableOfPurchase.addColumn(columnSellerCommissionFee, "ShopCommissionFee");

        final SingleSelectionModel<Purchase> selectionPurchaseModel = new SingleSelectionModel<>();
        cellTableOfPurchase.setSelectionModel(selectionPurchaseModel);
        selectionPurchaseModel.addSelectionChangeHandler(event -> {
            Purchase selected = selectionPurchaseModel.getSelectedObject();
            if (selected != null) {
                Window.alert("You selected: " + selected.getOrderNumber() + " " + selected.getSeller().getShopName() + " "
                        + selected.getSeller().getShopLocationArea());
            }
        });


        cellTableOfPurchase.setWidth("100%");
        cellTableOfPurchase.setRowCount(purchases.size(), true);
        cellTableOfPurchase.setRowData(0, purchases);
        cellTableOfPurchase.setColumnWidth(columnIdPurchase, 30, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnDate, 40, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnOrderNumber, 40, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnSellerName, 50, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnSellerLocationArea, 50, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnSellerCommissionFee, 50, Style.Unit.PX);
        vpPurchase.setBorderWidth(1);
        vpPurchase.setWidth("800px");
//        vpPurchase.add(cellTableOfPurchase);


//        FlexTable flexTable = createFlexTable();

        cellTableOfBooks.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);


        TextColumn<Books> columnId = new TextColumn<Books>() {
            @Override
            public String getValue(Books object) {
                return String.valueOf(object.getId());
            }
        };
        cellTableOfBooks.addColumn(columnId, "ID");

        TextColumn<Books> columnName = new TextColumn<Books>() {
            @Override
            public String getValue(Books object) {
                return object.getName();
            }
        };
        cellTableOfBooks.addColumn(columnName, "NAME");

        TextColumn<Books> costColumn = new TextColumn<Books>() {
            @Override
            public String getValue(Books object) {
                return String.valueOf(object.getCost());
            }
        };
        cellTableOfBooks.addColumn(costColumn, "COST");

        TextColumn<Books> warehouseColumn = new TextColumn<Books>() {
            @Override
            public String getValue(Books object) {
                return object.getWarehouse();
            }
        };
        cellTableOfBooks.addColumn(warehouseColumn, "WAREHOUSE");

        TextColumn<Books> quantityColumn = new TextColumn<Books>() {
            @Override
            public String getValue(Books object) {
                return String.valueOf(object.getQuantity());
            }
        };
        cellTableOfBooks.addColumn(quantityColumn, "QUANTITY");

        final SingleSelectionModel<Books> selectionModel = new SingleSelectionModel<>();
        cellTableOfBooks.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(event -> {

            Books selectedBook = selectionModel.getSelectedObject();
            if (selectedBook != null) {
                Window.alert("Selected: Name: " + selectedBook.getName() + ", Cost: " + selectedBook.getCost());
            }
        });



        cellTableOfBooks.setRowCount(books.size(), true);
        cellTableOfBooks.setRowData(0, books);
        cellTableOfBooks.setColumnWidth(columnId, 50, Style.Unit.PX);
        cellTableOfBooks.setColumnWidth(columnName, 200, Style.Unit.PX);
        cellTableOfBooks.setColumnWidth(costColumn, 50, Style.Unit.PX);
        cellTableOfBooks.setColumnWidth(warehouseColumn, 200, Style.Unit.PX);
        cellTableOfBooks.setColumnWidth(quantityColumn, 50, Style.Unit.PX);

        cellTableOfBooks.getColumn(1).setSortable(true);
        cellTableOfBooks.getColumn(2).setSortable(true);
        cellTableOfBooks.getColumn(3).setSortable(true);
        cellTableOfBooks.getColumn(4).setSortable(true);


        vp.setBorderWidth(1);
//        vp.add(flexTable);
        vp.add(cellTableOfBooks);
        pager.setDisplay(cellTableOfBooks);
        vp.add(pager);



        addBookButton.addClickHandler(event -> {

            addBookRequest();

            XMLHttpRequest req = XMLHttpRequest.create();
            req.open("GET", "http://localhost:8082/book/all", "false");
            req.setOnReadyStateChange(xhr -> {

                if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                    if (xhr.getStatus() == 200) {


                        JSONValue jsonValue = JSONParser.parseStrict(req.getResponseText());
                        JSONArray jsonArray = jsonValue.isArray();
                        books.clear();
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject obj = jsonArray.get(i).isObject();
                            books.add(new Books((int) obj.get("id").isNumber().doubleValue(),
                                                    obj.get("bookName").isString().stringValue(),
                                                    obj.get("bookCost").isNumber().doubleValue(),
                                                    obj.get("bookWarehouse").isString().stringValue(),
                                                    (int)obj.get("bookQuantity").isNumber().doubleValue()));
                        }

                        cellTableOfBooks.redraw();
                        cellTableOfBooks.setRowCount(books.size(), true);
                        cellTableOfBooks.setRowData(0, books);
                    }
                }
            });
            req.send();

        });


        deleteBookButton.addClickHandler(event -> {

            XMLHttpRequest req = XMLHttpRequest.create();
            req.open("DELETE", "http://localhost:8082/book/delete/" + idBox.getValue());

            cellTableOfBooks.setRowCount(books.size(), true);
            cellTableOfBooks.setRowData(0, books);
            req.send();
        });

        editBookButton.addClickHandler(event -> {

            XMLHttpRequest req = XMLHttpRequest.create();
            req.open("PUT", "http://localhost:8082/book/update/" + idBox.getValue());
            req.setRequestHeader(HEADER, HEADER_VALUE);


            Books send = new Books();
            send.setName(nameBox.getValue());
            send.setCost(Double.valueOf(costBox.getValue()));
            send.setWarehouse(warehouseBox.getValue());
            send.setQuantity(Integer.valueOf(quantityBox.getValue()));

            JSONString name = new JSONString(send.getName());
            JSONString cost = new JSONString(String.valueOf(send.getCost()));
            JSONString warehouse = new JSONString(send.getWarehouse());
            JSONString quantity = new JSONString(String.valueOf(send.getQuantity()));

            JSONObject toSend = new JSONObject();
            toSend.put("bookName", name);
            toSend.put("bookCost", cost);
            toSend.put("bookWarehouse", warehouse);
            toSend.put("bookQuantity", quantity);
            req.send(toSend.toString());
        });

//        DataGrid();

        RootPanel.get().add(menu);
        RootPanel.get().add(vp);
        RootPanel.get().add(boxPanel);
        RootPanel.get().add(bookBtnPanel);

//        RootPanel.get().add(purchaseDataGrid);
        RootPanel.get().add(vpPurchase);
        RootPanel.get().add(boxPurchasePanel);
        RootPanel.get().add(purchaseBtnPanel);


    }

    private FlexTable createFlexTable() {
        FlexTable flexTable = new FlexTable();
        flexTable.setWidth("500px");
        flexTable.getFlexCellFormatter().setColSpan(1, 0, 3);
        return flexTable;
    }

    private void DataGrid(){


        cellTableOfPurchase.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

        TextColumn<Purchase> colomnId = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getId());
            }
        };
        cellTableOfPurchase.addColumn(colomnId, "ID");

        TextColumn<Purchase> columnOrderNumber = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getOrderNumber());
            }
        };
        cellTableOfPurchase.addColumn(columnOrderNumber, "OrderNumber");

        TextColumn<Purchase> colomnDate = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getDate());
            }
        };
        cellTableOfPurchase.addColumn(colomnDate, "Date");

        TextColumn<Purchase> colomnSellerName = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getSeller().getShopName());
            }
        };
        cellTableOfPurchase.addColumn(colomnSellerName, "ShopName");

        TextColumn<Purchase> colomnSellerLocationArea = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getSeller().getShopLocationArea());
            }
        };
        cellTableOfPurchase.addColumn(colomnSellerLocationArea, "ShopLocationArea");

        TextColumn<Purchase> colomnSellerCommissionFee = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getSeller().getCommissionFee());
            }
        };
        cellTableOfPurchase.addColumn(colomnSellerCommissionFee, "ShopCommissionFee");

        final SingleSelectionModel<Purchase> selectionModel = new SingleSelectionModel<>();
        cellTableOfPurchase.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            public void onSelectionChange(SelectionChangeEvent event) {
                Purchase selected = selectionModel.getSelectedObject();
                if (selected != null) {
                    Window.alert("You selected: " + selected.getOrderNumber() + " " + selected.getSeller().getShopName() + " "
                            + selected.getSeller().getShopLocationArea());
                }
            }
        });
        cellTableOfPurchase.setRowCount(purchases.size(), true);
        cellTableOfPurchase.setRowData(0, purchases);
        cellTableOfPurchase.setWidth("100%");
        vpPurchase.add(cellTableOfPurchase);
        vpPurchase.setBorderWidth(1);
    }

    private void loadDataTable(){
        XMLHttpRequest req = XMLHttpRequest.create();
        req.open("GET", "http://localhost:8082/book/all", "true");
        req.setOnReadyStateChange(xhr -> {

            if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                if (xhr.getStatus() == 200) {
                    JSONValue jsonValue = JSONParser.parseLenient(req.getResponseText());
                    JSONArray jsonArray = jsonValue.isArray();
                    JSONObject obj = jsonArray.get(0).isObject();

                    for (int i = 0; i < jsonArray.size(); i++) {
                        books.add(new Books((int) obj.get("id").isNumber().doubleValue(),
                                obj.get("bookName").isString().stringValue(),
                                obj.get("bookCost").isNumber().doubleValue(),
                                obj.get("bookWarehouse").isString().stringValue(),
                                (int)obj.get("bookQuantity").isNumber().doubleValue()));
                    }
                }
            }
        });
        req.send();
        cellTableOfBooks.redraw();

        cellTableOfBooks.setRowCount(books.size(), true);
        cellTableOfBooks.setRowData(0, books);

    }


    private void addBookRequest(){
        XMLHttpRequest req = XMLHttpRequest.create();
        req.open("POST", "http://localhost:8082/book/add", "true");
        req.setRequestHeader(HEADER, HEADER_VALUE);


        Books send = new Books();
        send.setName(nameBox.getValue());
        send.setCost(Double.valueOf(costBox.getValue()));
        send.setWarehouse(warehouseBox.getValue());
        send.setQuantity(Integer.valueOf(quantityBox.getValue()));

        JSONString name = new JSONString(send.getName());
        JSONString cost = new JSONString(String.valueOf(send.getCost()));
        JSONString warehouse = new JSONString(send.getWarehouse());
        JSONString quantity = new JSONString(String.valueOf(send.getQuantity()));

        JSONObject toSend = new JSONObject();
        toSend.put("bookName", name);
        toSend.put("bookCost", cost);
        toSend.put("bookWarehouse", warehouse);
        toSend.put("bookQuantity", quantity);
        req.send(toSend.toString());
    }

}
