import environment.Data;
import gui.AppletFrame;
import injection.ClientInjector;
import reflection.cache.Loader;
import rsloader.PageParser;

public class Boot {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        /**
         * Obtaining all page PARAMETERS
         */
        new PageParser();
        /**
         * Loading all ClassNodes
         * Injecting Canvas into the client
         * Saving injected Client
         */
        ClientInjector.injectClient("gamepack.jar");
        /**
         * Starting client GUI + APPLET
         * */
        Data.appletFrame = new AppletFrame();
        /**
         * Loading our hooked classes and fields
         * */
        Loader.loadCache();
    }

}
