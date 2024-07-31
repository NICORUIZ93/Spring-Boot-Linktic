package com.LINKTIC.Linktic.constans;

public class coreRouter {
    public static final String API_BASE_PATH = "/linktic/api";

    private coreRouter() {
        throw new IllegalStateException();
    }

    public static class LiquidacionRoutes {
        public static final String ROOT = API_BASE_PATH + "/liquidacion";

        private LiquidacionRoutes() {
            throw new IllegalStateException("LiquidacionRoutes");
        }
    }
}
