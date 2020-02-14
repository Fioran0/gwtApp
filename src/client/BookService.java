package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("bookservice")
public interface BookService extends RemoteService {

    void getBooks();
}
