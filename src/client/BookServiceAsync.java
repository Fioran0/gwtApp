package client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BookServiceAsync {
    void getBooks(AsyncCallback callback);
}
