package fatcat.pizzagps;

import java.util.ArrayList;
import java.util.List;

import fatcat.pizzagps.GoogleMap.GoogleMapAPI;

/**
 * Created by Elias on 2018-01-08.
 */

public class FakeGoogleAPI implements GoogleMapAPI {

    /*
    * Used for testing purposes
    * */

    public boolean called = false;

    @Override
    public String positionSearch(String keyWord, Position pos) {

        System.out.println("Request to fake API");
        System.out.println("Keyword: "+keyWord);
        System.out.println("Position: "+pos);

        called = true;
        return response1;
    }

    public static List<Pizzeria> pizzeriasFromResponse1(){
        List<Pizzeria> pList = new ArrayList<>();
        pList.add(pizzeria_1());
        pList.add(pizzeria_2());
        pList.add(pizzeria_3());
        return pList;
    }


    private static Pizzeria pizzeria_1(){
        /*
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.8402955,\n" +
            "                    \"lng\": 12.2975693\n" +
            "                },\n" +
            "            \"id\": \"03478ecaeb2a9f35835877464a41396517ee2aab\",\n" +
            "            \"name\": \"Pizzeria campino\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"place_id\": \"ChIJW4ooY2lXRUYRKifEUttlZ2o\",\n" +
            "            \"rating\": 4.3,\n" +
        * */
        Pizzeria p = new Pizzeria();
        p.name = "Pizzeria campino";
        p.id = "03478ecaeb2a9f35835877464a41396517ee2aab";
        p.pos = new Position(57.8402955,12.2975693);
        p.place_id = "ChIJW4ooY2lXRUYRKifEUttlZ2o";
        p.openNow = false;
        p.rating = 4.3;
        return p;
    }

    private static Pizzeria pizzeria_2(){

        /*
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.8358344,\n" +
            "                    \"lng\": 12.2988054\n" +
            "                },\n" +
            "            \"id\": \"362c8b4e5f167c913459db8e10db829ed7dac75f\",\n" +
            "            \"name\": \"Grabo restaurant and pizzeria\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"place_id\": \"ChIJSdtnXGxXRUYROpX1rK7_RsE\",\n" +
            "            \"rating\": 4.4,\n" +
        * */
        Pizzeria p = new Pizzeria();
        p.name = "Grabo restaurant and pizzeria";
        p.id = "362c8b4e5f167c913459db8e10db829ed7dac75f";
        p.pos = new Position(57.8358344,12.2988054);
        p.place_id = "ChIJSdtnXGxXRUYROpX1rK7_RsE";
        p.openNow = false;
        p.rating = 4.4;
        return p;
    }

    private static Pizzeria pizzeria_3(){
        /*
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.7925458,\n" +
            "                    \"lng\": 12.3092205\n" +
            "                },\n" +
            "            \"id\": \"aefb33ca585fc81bef6ed8453456e5f2e6c1d70d\",\n" +
            "            \"name\": \"El Dorado House\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"place_id\": \"ChIJvW4b0svyT0YRpFUNC8qOfz8\",\n" +
            "            \"rating\": 4.2,\n" +
        * */
        Pizzeria p = new Pizzeria();
        p.name = "El Dorado House";
        p.id = "aefb33ca585fc81bef6ed8453456e5f2e6c1d70d";
        p.pos = new Position(57.7925458,12.3092205);
        p.place_id = "ChIJvW4b0svyT0YRpFUNC8qOfz8";
        p.openNow = false;
        p.rating = 4.2;
        return p;
    }


    private static String response1 = "{\n" +
            "    \"html_attributions\": [],\n" +
            "    \"next_page_token\": \"CqQCGwEAAORuh_5XV_JrH_hTzZ8gm29z8sS3wYJZNcc7LL8SyT4huI95oKHuwgeGVv0PJtfTxD6QdVFRFmAJMOY8ILNuOw-hzL0ytPoLVgiweRQL2YzPaWuA0K05tHfkSVz6LRW10g4_h-pBkj8diFfgnFm5BNYnoH4GIa_1vAvXdWK2x30hTWElcvA6YMB0JxRRjtJL-7j-m2bkEiOaH2m-kYdIQIvHbrxkU2njlD6mcoH_mpjL1jHVuW2yW91AZ2Yadx3OzMxI15qCsrwpSCsXY7dEODUpgDKvOuEcYKfd9GaYrgv68DagoEiHu0TcQA_4O80nq0Qu6s3-iGtSXMmPQIxvKidteEnGTucFvTlC8cLkL-7Io3Iq7r6kS1fKQ4Qxvs2uChIQRX3K7v8lj-Jd8lnZOpXbixoUsMfZOGtEg_Xk-V72BnLAWAXSqtc\",\n" +
            "    \"results\": [\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.8402955,\n" +
            "                    \"lng\": 12.2975693\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.84164448029151,\n" +
            "                        \"lng\": 12.2989182802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.83894651970849,\n" +
            "                        \"lng\": 12.2962203197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"03478ecaeb2a9f35835877464a41396517ee2aab\",\n" +
            "            \"name\": \"Pizzeria campino\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 3024,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/102260577433132882001/photos\\\">Björn Nilsson</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAA1xfhSvrH_m-YPAHAXAEvcmNSP887Ox3_j56e_SVnE0ErGrUWDWDUd9ZAlDGWTSYy_7sHagaSqEzL3H1PeHB50h6kwNozTgUZmHgkFsfjlRB5P-hqIJ6oDxa7As34pDwREhBenKwlTg0Hh9iGNFf0Jf2OGhQ8Hzc-r5VezbRW611cEWHvJ2_FKw\",\n" +
            "                    \"width\": 4032\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJW4ooY2lXRUYRKifEUttlZ2o\",\n" +
            "            \"rating\": 4.3,\n" +
            "            \"reference\": \"CmRRAAAAqZu4hCu1tTtplzBGBqCkgHAwlK8guXnouGO51vlD6PR1JztW1MEHVesUPUQjVcARmbwVXnZX5ca1seTe-Iwol3UtDGv6R_tm8Om1D6xxP6ZU1K_s8bV1Y26ytDRs6xLPEhDjmEydYOeov-3dHhLDzn_CGhTxms5r5bxiL1ikuo_Yj5zvb6bwvQ\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"443 43, Lundbyvägen 2, Gråbo\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.8358344,\n" +
            "                    \"lng\": 12.2988054\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.8371833802915,\n" +
            "                        \"lng\": 12.3001543802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.83448541970849,\n" +
            "                        \"lng\": 12.2974564197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"362c8b4e5f167c913459db8e10db829ed7dac75f\",\n" +
            "            \"name\": \"Grabo restaurant and pizzeria\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 2448,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/108733639376061537811/photos\\\">Gråbo restaurang och pizzeria</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAUwWXImSui46S6AdFtIYZc9jU7y5T8OfMC14nmyVOwMg2aX2nta8YDMmWZm2jQiEolxLCbhUF4vQxgjS2lYGBY7oRWIijf2qWrMa0zrLRaBhEQFZR47-aqtfNuak2E4zVEhDAafManfolRogEh9R8CF4xGhQMDMS3aXLcfmAHq83wr_gA-9zVEQ\",\n" +
            "                    \"width\": 3264\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJSdtnXGxXRUYROpX1rK7_RsE\",\n" +
            "            \"rating\": 4.4,\n" +
            "            \"reference\": \"CmRSAAAArSS0ewXMFsOcnWLhWj6i5XJgal8ENgI7N4GDxGvgYBWBz-71zXePuK4R8d_fVEDiRov0YZjRjtLPSSZm7xjjgUzvpxjkjEzsmC0GhEZf5GbVZSbBMk9ZimoG2d0vYB3IEhDO0fcf3Cg6AjdVL42IrHRyGhQ5heoa1uLupVpK9UNx7_cXsY5_0g\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Mjörnbotorget 6, Gråbo\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.7925458,\n" +
            "                    \"lng\": 12.3092205\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.7938078802915,\n" +
            "                        \"lng\": 12.3101284302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.79110991970849,\n" +
            "                        \"lng\": 12.3074304697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"aefb33ca585fc81bef6ed8453456e5f2e6c1d70d\",\n" +
            "            \"name\": \"El Dorado House\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 4128,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/116939878629258130934/photos\\\">Anders Grönberg</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAo3kjTPTr2uh8c7wTapO00E0wco6CVokEYMCvK4svxaH8zLnG3ivnIbBa02rP17x0AjMT9HDUtOm94G0seuDEZcqfbjWrRDrXz8atG6kRBqPWjICexIJJiLsFEQ2SBoULEhCDi6ep8WO5N9TJFR5G3x2tGhRjrKbp0rlxRdY_DHEOZtxT-tMagw\",\n" +
            "                    \"width\": 3096\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJvW4b0svyT0YRpFUNC8qOfz8\",\n" +
            "            \"rating\": 4.2,\n" +
            "            \"reference\": \"CmRRAAAAQ7DQRh8gUplnXswyAkdKqE_mWesBb3NYlZu-9SfKZq0TM-unw1ugr1LxUSx5KoAIHQzqL_-xaXkYWtcXzsmVbI_fIccnTvI6mf-F6IrlDG_4bLrNEfFwQVTigb4HA3pWEhBZFw5jfytGB89Bcsrni_SiGhQBCLt3hgVD1IGIgglW-GAG5BZK5g\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Gråbovägen 13, Stenkullen\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"status\": \"OK\"\n" +
            "}";



}
