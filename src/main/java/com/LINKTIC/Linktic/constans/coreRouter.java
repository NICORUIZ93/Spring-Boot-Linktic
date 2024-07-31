package com.LINKTIC.Linktic.constans;

public class coreRouter {
    private coreRouter() {
        throw new IllegalStateException();
    }

    public static final String API_BASE_PATH = "/linktic/api";

    public static class LiquidacionRoutes {
        private LiquidacionRoutes() {
            throw new IllegalStateException("LiquidacionRoutes");
        }

        public static final String ROOT = API_BASE_PATH + "/liquidacion";
    }
}
