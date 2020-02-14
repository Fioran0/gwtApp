package client;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;


import com.google.gwt.json.client.*;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.*;
import com.google.gwt.xhr.client.XMLHttpRequest;

import java.sql.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.*;


public class BooksEntry implements EntryPoint {

    public static final String HEADER = "content-type";
    public static final String HEADER_VALUE = "application/json";

    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_PUT= "PUT";
    public static final String HTTP_METHOD_DELETE = "DELETE";


    private List<Books> books = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<Purchase>();
    private List<Buyer> buyers = new ArrayList<>();
<<<<<<< HEAD
    private List<Shop> sellers = new ArrayList<>();
    private Map<String, Books> bookMap = new HashMap();
    private Map<String, Buyer> buyerMap = new HashMap();
    private Map<String, Shop> shopMap = new HashMap();
=======
>>>>>>> master

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

    private final ListBox booksListBox = new ListBox();
    private final ListBox buyersListBox = new ListBox();
<<<<<<< HEAD
    private final ListBox sellerListBox = new ListBox();
=======
>>>>>>> master

    private final TextBox idBox = new TextBox();
    private final TextBox nameBox = new TextBox();
    private final TextBox costBox = new TextBox();
    private final TextBox warehouseBox = new TextBox();
    private final TextBox quantityBox = new TextBox();
<<<<<<< HEAD
    private final TextBox purchaseIdBox = new TextBox();
=======
>>>>>>> master
    private final TextBox purchaseDateBox = new TextBox();
    private final TextBox purchaseOrderNumberBox = new TextBox();
    private final TextBox purchaseQuantityBox = new TextBox();
    private final TextBox purchaseSumBox = new TextBox();
<<<<<<< HEAD

=======
>>>>>>> master
    private final CellTable<Books> cellTableOfBooks = new CellTable<>();
    private final DataGrid<Purchase> cellTableOfPurchase = new DataGrid();

    private final ListDataProvider<Purchase> listDataProvider = new ListDataProvider<>();



    public void onModuleLoad() {

        Command cmd = () -> Window.alert("//todo");



        menu.addItem("books", (Command) () -> {
            vp.setVisible(true);
            bookBtnPanel.setVisible(true);
            boxPanel.setVisible(true);
            purchaseBtnPanel.setVisible(false);
            vpPurchase.setVisible(false);
            boxPurchasePanel.setVisible(false);
        });
        menu.addItem("purchase", (Command) () -> {
            vp.setVisible(false);
            bookBtnPanel.setVisible(false);
            boxPanel.setVisible(false);
            vpPurchase.setVisible(true);
            cellTableOfPurchase.setVisible(true);
            purchaseBtnPanel.setVisible(true);
            boxPurchasePanel.setVisible(true);
<<<<<<< HEAD
            loadBookList();
            loadBuyerList();
            loadSellerList();
=======
>>>>>>> master
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

<<<<<<< HEAD
        boxPurchasePanel.add(purchaseIdBox);
        purchaseIdBox.setText("id");
=======

>>>>>>> master
        boxPurchasePanel.add(purchaseOrderNumberBox);
        purchaseOrderNumberBox.setText("OrderNumber");
        boxPurchasePanel.add(purchaseDateBox);
        purchaseDateBox.setText("Date");
        boxPurchasePanel.add(purchaseQuantityBox);
        purchaseQuantityBox.setText("Quantity");
        boxPurchasePanel.add(purchaseSumBox);
<<<<<<< HEAD
        purchaseSumBox.setText("Sum");
        boxPurchasePanel.add(booksListBox);
        boxPurchasePanel.add(buyersListBox);
        boxPurchasePanel.add(sellerListBox);
=======
        purchaseSumBox.setText("Sun");
        boxPurchasePanel.add(booksListBox);
        boxPurchasePanel.add(buyersListBox);

>>>>>>> master

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
        boxPurchasePanel.setVisible(false);
        purchaseBtnPanel.add(addPurchaseButton);
        purchaseBtnPanel.add(editPurchaseButton);
        purchaseBtnPanel.add(deletePurchaseButton);
        addPurchaseButton.setText("Add");
        editPurchaseButton.setText("Edit");
        deletePurchaseButton.setText("Delete");

        listDataProvider.addDataDisplay(cellTableOfPurchase);
        listDataProvider.setList(purchases);
        cellTableOfPurchase.setSize("1200px", "500px");


        SimplePager pager = new SimplePager(SimplePager.TextLocation.CENTER, (SimplePager.Resources) GWT.create(SimplePager.Resources.class),
                false, 10, true) {
            @Override
            public void startLoading() {
                super.startLoading();
            }

            @Override
            protected void onRangeOrRowCountChanged() {
                super.onRangeOrRowCountChanged();
            }

            @Override
            public boolean hasNextPage() {
                if (this.getPage() < (this.getPageCount() - 1)) {
                    return true;
                }
                return false;
            }

        };

        pager.setDisplay(cellTableOfBooks);
        pager.setPageSize(20);

        vpPurchase.add(cellTableOfPurchase);



        addPurchaseButton.addClickHandler(event -> {
            /*purchases.add(new Purchase(123, 264562, new Date(20, 11, 5),
                    new Shop(123, "TEST", "TESTAREA", 99.9),
                    new Buyer(123, "test", "testarea", 88.8), 9, 1000.0,
                    new Books(123, "test", 1000.0, "test", 9)));*/

            XMLHttpRequest req = XMLHttpRequest.create();
            req.open("POST", "http://localhost:8082/purchase/add", "true");
            req.setRequestHeader(HEADER, HEADER_VALUE);

            Purchase send = new Purchase();
            send.setOrderNumber(Integer.valueOf(purchaseOrderNumberBox.getValue()));
//            send.setDate(new Date(Long.valueOf(purchaseDateBox.getValue())));
            send.setQuantity(Integer.valueOf(purchaseQuantityBox.getValue()));
            send.setSum(Double.valueOf(purchaseSumBox.getValue()));

            send.setDate(new Date(119,11,11));

            send.setBook(bookMap.get(booksListBox.getSelectedItemText()));
            send.setBuyer(buyerMap.get(buyersListBox.getSelectedItemText()));
            send.setSeller(shopMap.get(sellerListBox.getSelectedItemText()));

            JSONString orderNumber = new JSONString(String.valueOf(send.getOrderNumber()));
            JSONString Date = new JSONString(String.valueOf(send.getDate()));
            JSONString quantity = new JSONString(String.valueOf(send.getQuantity()));
            JSONString sum = new JSONString(String.valueOf(send.getSum()));

            JSONObject shop = new JSONObject();
            shop.put("shopName", new JSONString(send.getSeller().getShopName()));
            shop.put("shopLocationArea", new JSONString(send.getSeller().getShopLocationArea()));
            shop.put("commissionFee", new JSONString(String.valueOf(send.getSeller().getCommissionFee())));

            JSONObject Buyer = new JSONObject();
            Buyer.put("surname", new JSONString(send.getBuyer().getSurname()));
            Buyer.put("residenceArea", new JSONString(send.getBuyer().getResidenceArea()));
            Buyer.put("discount", new JSONString(String.valueOf(send.getBuyer().getDiscount())));

            JSONArray bookArray = new JSONArray();
            JSONObject Book = new JSONObject();
            Book.put("bookName", new JSONString(send.getBook().getName()));
            Book.put("bookCost", new JSONString(String.valueOf(send.getBook().getCost())));
            Book.put("bookWarehouse", new JSONString(send.getBook().getWarehouse()));
            Book.put("bookQuantity", new JSONString(String.valueOf(send.getBook().getQuantity())));

            bookArray.set(0, Book);

            JSONObject toSend = new JSONObject();
            toSend.put("orderNumber", orderNumber);
            toSend.put("date", Date);
            toSend.put("quantity", quantity);
            toSend.put("sum", sum);
            toSend.put("book", bookArray);
            toSend.put("buyer", Buyer);
            toSend.put("seller", shop);
            req.send(toSend.toString());

            XMLHttpRequest req = XMLHttpRequest.create();
            req.open("POST", "http://localhost:8082/purchase/add", "true");
            req.setRequestHeader(HEADER, HEADER_VALUE);

            Purchase send = new Purchase();
            send.setOrderNumber(Integer.valueOf(purchaseOrderNumberBox.getValue()));
            send.setDate(new Date(Long.valueOf(purchaseDateBox.getValue())));
            send.setQuantity(Integer.valueOf(purchaseQuantityBox.getValue()));
            send.setSum(Double.valueOf(purchaseSumBox.getValue()));
            send.setBook(books.get(1));
            send.setBuyer(buyers.get(1));
            send.setSeller(new Shop("testshop", "testshop", 111.0));

            JSONString orderNumber = new JSONString(String.valueOf(send.getOrderNumber()));
            JSONString Date = new JSONString(String.valueOf(send.getDate()));
            JSONString quantity = new JSONString(String.valueOf(send.getQuantity()));
            JSONString sum = new JSONString(String.valueOf(send.getSum()));

            JSONObject shop = new JSONObject();
            shop.put("shopName", new JSONString(send.getSeller().getShopName()));
            shop.put("shopLocationArea", new JSONString(send.getSeller().getShopLocationArea()));
            shop.put("commissionFee", new JSONString(String.valueOf(send.getSeller().getCommissionFee())));

            JSONObject Buyer = new JSONObject();
            Buyer.put("surname", new JSONString(send.getBuyer().getSurname()));
            Buyer.put("residenceArea", new JSONString(send.getBuyer().getResidenceArea()));
            Buyer.put("discount", new JSONString(String.valueOf(send.getBuyer().getDiscount())));

            JSONObject Book = new JSONObject();
            Book.put("bookName", new JSONString(send.getBook().getName()));
            Book.put("bookCost", new JSONString(String.valueOf(send.getBook().getCost())));
            Book.put("bookWarehouse", new JSONString(send.getBook().getWarehouse()));
            Book.put("bookQuantity", new JSONString(String.valueOf(send.getBook().getQuantity())));

            JSONObject toSend = new JSONObject();
            toSend.put("orderNumber", orderNumber);
            toSend.put("date", Date);
            toSend.put("quantity", quantity);
            toSend.put("sum", sum);
            toSend.put("book", Book);
            toSend.put("buyer", Buyer);
            toSend.put("seller", shop);
            req.send(toSend.toString());

            cellTableOfPurchase.redraw();
            cellTableOfPurchase.setRowCount(purchases.size(), true);
            cellTableOfPurchase.setRowData(0, purchases);
        });

        editPurchaseButton.addClickHandler(event -> {
            purchases.clear();
            XMLHttpRequest req = XMLHttpRequest.create();
            req.open(HTTP_METHOD_GET, "http://localhost:8082/purchase/all", "false");
            req.setOnReadyStateChange(xhr -> {

                if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                    if (xhr.getStatus() == 200) {

                        JSONValue jsonValue = JSONParser.parseLenient(req.getResponseText());
                        JSONArray jsonArray = jsonValue.isArray();
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject obj = jsonArray.get(i).isObject();
<<<<<<< HEAD

                            JSONArray bookTmp = obj.get("book").isArray();
=======
//                            JSONArray shopTmp = obj.get("seller").isArray();
                            JSONObject buyerTmp = obj.get("buyer").isObject();
                            JSONArray bookTmp = obj.get("book").isArray();

//                            JSONObject shopObj = shopTmp.get(0).isObject();
>>>>>>> master
                            JSONObject bookObj = bookTmp.get(0).isObject();
                            JSONObject shopOb = obj.get("seller").isObject();
                            JSONObject buyerObj = obj.get("buyer").isObject();

//                            Shop shop = new Shop(11,"11", "11", 11.1);
                            Shop shop = new Shop();
                            shop.setId((int)shopOb.get("id").isNumber().doubleValue());
                            shop.setShopName(shopOb.get("shopName").isString().stringValue());
                            shop.setShopLocationArea(shopOb.get("shopLocationArea").isString().stringValue());
                            shop.setCommissionFee(shopOb.get("commissionFee").isNumber().doubleValue());


                            Buyer buyer = new Buyer();
                            buyer.setId((int)buyerTmp.get("id").isNumber().doubleValue());
                            buyer.setSurname(buyerTmp.get("surname").isString().stringValue());
                            buyer.setResidenceArea(buyerTmp.get("residenceArea").isString().stringValue());
                            buyer.setDiscount(buyerTmp.get("discount").isNumber().doubleValue());


                            Books book = new Books();

                            book.setId((int)bookObj.get("id").isNumber().doubleValue());
                            book.setName(bookObj.get("bookName").isString().stringValue());
                            book.setWarehouse(bookObj.get("bookWarehouse").isString().stringValue());
                            book.setCost(bookObj.get("bookCost").isNumber().doubleValue());
                            book.setQuantity((int)bookObj.get("bookQuantity").isNumber().doubleValue());

                            String [] arr = obj.get("date").isString().stringValue().split("-");
                            String date = arr[0] + arr[1] + arr[2];


                            purchases.add(new Purchase((int)obj.get("id").isNumber().doubleValue(),
                                                        (int)obj.get("orderNumber").isNumber().doubleValue(),
//                                                        new Date(Long.valueOf(obj.get("date").isString().stringValue())),
//                                                        new Date(119,11,15),
                                                        new Date(Long.valueOf(date)),
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

        deletePurchaseButton.addClickHandler(clickEvent -> {
            XMLHttpRequest req = XMLHttpRequest.create();
            req.open(HTTP_METHOD_DELETE, "http://localhost:8082/purchase/delete/" + purchaseIdBox.getValue());

            req.send();
            cellTableOfPurchase.redraw();
            cellTableOfPurchase.setRowCount(purchases.size(), true);
            cellTableOfPurchase.setRowData(0, purchases);

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
        cellTableOfPurchase.addColumn(columnSellerCommissionFee, "ShopFee");

        TextColumn<Purchase> columnBuyerSurname = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getBuyer().getSurname());
            }
        };
        cellTableOfPurchase.addColumn(columnBuyerSurname, "BuyerSurname");

        TextColumn<Purchase> columnBuyerArea = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getBuyer().getResidenceArea());
            }
        };
        cellTableOfPurchase.addColumn(columnBuyerArea, "BuyerArea");

        TextColumn<Purchase> columnBookName = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getBook().getName());
            }
        };
        cellTableOfPurchase.addColumn(columnBookName, "BookName");

        TextColumn<Purchase> columnBookCost = new TextColumn<Purchase>() {
            @Override
            public String getValue(Purchase object) {
                return String.valueOf(object.getBook().getCost());
            }
        };
        cellTableOfPurchase.addColumn(columnBookCost, "BookCost");



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
        cellTableOfPurchase.setColumnWidth(columnDate, 80, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnOrderNumber, 100, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnSellerName, 80, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnSellerLocationArea, 100, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnSellerCommissionFee, 60, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnBuyerSurname, 100, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnBuyerArea, 100, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnBookName, 120, Style.Unit.PX);
        cellTableOfPurchase.setColumnWidth(columnBookCost, 60, Style.Unit.PX);
        vpPurchase.setBorderWidth(1);
        vpPurchase.setWidth("1200px");
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
        vp.add(cellTableOfBooks);
        vp.add(pager);



        addBookButton.addClickHandler(event -> {

            addBookRequest();
            loadBuyerList();

            XMLHttpRequest req = XMLHttpRequest.create();
            req.open(HTTP_METHOD_GET, "http://localhost:8082/book/all", "false");
            req.setOnReadyStateChange(xhr -> {

                if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                    if (xhr.getStatus() == 200) {


                        JSONValue jsonValue = JSONParser.parseStrict(req.getResponseText());
                        JSONArray jsonArray = jsonValue.isArray();
                        books.clear();
                        booksListBox.clear();
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject obj = jsonArray.get(i).isObject();
                            booksListBox.addItem(obj.get("bookName").isString().stringValue());
<<<<<<< HEAD
                            Books tmpBook = new Books((int) obj.get("id").isNumber().doubleValue(),
                                    obj.get("bookName").isString().stringValue(),
                                    obj.get("bookCost").isNumber().doubleValue(),
                                    obj.get("bookWarehouse").isString().stringValue(),
                                    (int)obj.get("bookQuantity").isNumber().doubleValue());
                            books.add(tmpBook);
                            bookMap.put(tmpBook.getName(), tmpBook);

=======
                            books.add(new Books((int) obj.get("id").isNumber().doubleValue(),
                                                    obj.get("bookName").isString().stringValue(),
                                                    obj.get("bookCost").isNumber().doubleValue(),
                                                    obj.get("bookWarehouse").isString().stringValue(),
                                                    (int)obj.get("bookQuantity").isNumber().doubleValue()));
>>>>>>> master
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
            req.open(HTTP_METHOD_DELETE, "http://localhost:8082/book/delete/" + idBox.getValue());

            cellTableOfBooks.setRowCount(books.size(), true);
            cellTableOfBooks.setRowData(0, books);
            req.send();
        });

        editBookButton.addClickHandler(event -> {

            XMLHttpRequest req = XMLHttpRequest.create();
            req.open(HTTP_METHOD_PUT, "http://localhost:8082/book/update/" + idBox.getValue());
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

<<<<<<< HEAD

=======
>>>>>>> master

        RootPanel.get().add(menu);
        RootPanel.get().add(vp);
        RootPanel.get().add(boxPanel);
        RootPanel.get().add(bookBtnPanel);

//        RootPanel.get().add(purchaseDataGrid);
        RootPanel.get().add(vpPurchase);
        RootPanel.get().add(boxPurchasePanel);
        RootPanel.get().add(purchaseBtnPanel);

        loadBookList();


    }

    private FlexTable createFlexTable() {
        FlexTable flexTable = new FlexTable();
        flexTable.setWidth("500px");
        flexTable.getFlexCellFormatter().setColSpan(1, 0, 3);
        return flexTable;
    }



    private void loadBookList(){
        XMLHttpRequest req = XMLHttpRequest.create();
        req.open(HTTP_METHOD_GET, "http://localhost:8082/book/all", "true");

        req.setOnReadyStateChange(xhr -> {

            if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                if (xhr.getStatus() == 200) {
                    JSONValue jsonValue = JSONParser.parseLenient(req.getResponseText());
                    JSONArray jsonArray = jsonValue.isArray();
<<<<<<< HEAD
                    books.clear();
                    booksListBox.clear();

                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject obj = jsonArray.get(i).isObject();

                        booksListBox.addItem(obj.get("bookName").isString().stringValue());
                        Books tmpBook = new Books((int) obj.get("id").isNumber().doubleValue(),
=======

                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject obj = jsonArray.get(0).isObject();
                        booksListBox.addItem(obj.get("bookName").isString().stringValue());
                        books.add(new Books((int) obj.get("id").isNumber().doubleValue(),
>>>>>>> master
                                obj.get("bookName").isString().stringValue(),
                                obj.get("bookCost").isNumber().doubleValue(),
                                obj.get("bookWarehouse").isString().stringValue(),
                                (int)obj.get("bookQuantity").isNumber().doubleValue());
                        books.add(tmpBook);
                        bookMap.put(tmpBook.getName(), tmpBook);
                    }
                }
            }

            cellTableOfBooks.redraw();
            cellTableOfBooks.setRowCount(books.size(), true);
            cellTableOfBooks.setRowData(0, books);
        });
        req.send();
<<<<<<< HEAD
/*        cellTableOfBooks.redraw();

        cellTableOfBooks.setRowCount(books.size(), true);
        cellTableOfBooks.setRowData(0, books);*/

    }

=======
    }

>>>>>>> master
    private void loadBuyerList() {
        {
            XMLHttpRequest req = XMLHttpRequest.create();
            req.open("GET", "http://localhost:8082/buyer/all", "true");
            req.setOnReadyStateChange(xhr -> {

                if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                    if (xhr.getStatus() == 200) {
                        JSONValue jsonValue = JSONParser.parseLenient(req.getResponseText());
                        JSONArray jsonArray = jsonValue.isArray();
<<<<<<< HEAD
                        buyers.clear();
                        buyersListBox.clear();

                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject obj = jsonArray.get(i).isObject();

                            buyersListBox.addItem(obj.get("surname").isString().stringValue());
                            Buyer tmpBuyer = new Buyer((int) obj.get("id").isNumber().doubleValue(),
                                    obj.get("surname").isString().stringValue(),
                                    obj.get("residenceArea").isString().stringValue(),
                                    obj.get("discount").isNumber().doubleValue());
                            buyers.add(tmpBuyer);
                            buyerMap.put(tmpBuyer.getSurname(), tmpBuyer);
                        }
                    }
                }
            });
            req.send();
        }
    }

    private void loadSellerList() {
        {
            XMLHttpRequest req = XMLHttpRequest.create();
            req.open("GET", "http://localhost:8082/shop/all", "true");
            req.setOnReadyStateChange(xhr -> {

                if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                    if (xhr.getStatus() == 200) {
                        JSONValue jsonValue = JSONParser.parseLenient(req.getResponseText());
                        JSONArray jsonArray = jsonValue.isArray();
                        sellers.clear();
                        sellerListBox.clear();

                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject obj = jsonArray.get(i).isObject();

                            sellerListBox.addItem(obj.get("shopName").isString().stringValue());
                            Shop tmpSeller = new Shop((int) obj.get("id").isNumber().doubleValue(),
                                    obj.get("shopName").isString().stringValue(),
                                    obj.get("shopLocationArea").isString().stringValue(),
                                    obj.get("commissionFee").isNumber().doubleValue());
                            sellers.add(tmpSeller);
                            shopMap.put(tmpSeller.getShopName(), tmpSeller);
=======
                        buyersListBox.clear();

                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject obj = jsonArray.get(i).isObject();

                            buyersListBox.addItem(obj.get("surname").isString().stringValue());
                            buyers.add(new Buyer((int) obj.get("id").isNumber().doubleValue(),
                                    obj.get("surname").isString().stringValue(),
                                    obj.get("residenceArea").isString().stringValue(),
                                    obj.get("discount").isNumber().doubleValue()));
>>>>>>> master
                        }
                    }
                }
            });
            req.send();
        }
    }


    private void addBookRequest(){
        XMLHttpRequest req = XMLHttpRequest.create();
        req.open(HTTP_METHOD_POST, "http://localhost:8082/book/add", "true");
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
