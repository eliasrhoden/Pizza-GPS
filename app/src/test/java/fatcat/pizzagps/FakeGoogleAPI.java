package fatcat.pizzagps;

import java.util.List;

/**
 * Created by Elias on 2018-01-08.
 */

public class FakeGoogleAPI implements GoogleMapAPI {

    /*
    * Used for testing purposes
    * */

    @Override
    public String positionSearch(String keyWord, Position pos) {

        System.out.println("Request to fake API");
        System.out.println("Keyword: "+keyWord);
        System.out.println("Position: "+pos);

        return response1;
    }

    private List<Pizzeria> pizzeriasFromResponse1(){
        //TODO, manually create a List with the pizzerias found in the JSON response 'response1'-String. We don't need every pizzeria in the response, but at least 3.
        return null;
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
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.8077585,\n" +
            "                    \"lng\": 12.3587836\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.8092609302915,\n" +
            "                        \"lng\": 12.3595753802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.80656296970849,\n" +
            "                        \"lng\": 12.3568774197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"38e9bca5fd3e4eb82db1c2d72cc8b50115c873c5\",\n" +
            "            \"name\": \"Floda Pizzeria O Grill\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 2160,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/108582683738723023715/photos\\\">Shiyar Alo</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAA_qT24aIsE4F69vYTgWWPALu7w0c3VvrsTDy30jsOLWyfL35x8Bnr62m-Ky75S-6OKq7z6JPv4wx2lQ1pk50bAcP3eGk7na9hB5G4LKME8wjmdEz3gdHRelA_09hIoSeEEhDJfr7na1EM49z70-ew0mhDGhS6xIehpV21V5CmuDiNLanpQBRfIg\",\n" +
            "                    \"width\": 3840\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJwaFp0l1WRUYRQE-kq4ISYyo\",\n" +
            "            \"rating\": 4.3,\n" +
            "            \"reference\": \"CmRRAAAAC2M3wGXRQZFDcE4bvwiB6SDOlD7x0t-7RFtk6eojLxiC_cG4BNxpu7k4QUf_xfhuVY78mYFApOqzmt8cb8I_p97lzzUQHPwGRa1rMfkohbA8sxF8yRORbV29zQ3XQINwEhDN5NPZROphLP5D4haa2mAuGhQ4RlsDJErHx0gkmQSQucq0Cz4Kbg\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Floda stationsväg 9, Floda\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.80953880000001,\n" +
            "                    \"lng\": 12.3620224\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.81093338029151,\n" +
            "                        \"lng\": 12.3633277302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.8082354197085,\n" +
            "                        \"lng\": 12.3606297697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"72e65d6b5036a99e74d5873fbd93e49986e2343f\",\n" +
            "            \"name\": \"ANCONA PIZZERIA GRILL\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 3024,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/113311943497244655062/photos\\\">Johan Rova</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAhR_EdmKV9pYMBRfUM07LwT_Lf6vmukfHiEdZlH6v-8NFXqvDObp1rlPLgpQfQgyWyoMLwNLeuan4T9gMy5JKKWLAPVlkT0NEqFqiGtS2YGagDFbdPzid0TlaRXLeIaakEhBCjUmbuEpivYC7zhJYpwCxGhQ_-OQvyI2kkvCE7nPbnl97dC0YWw\",\n" +
            "                    \"width\": 4032\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJUXR6DV5WRUYRdLvKjWGTUkQ\",\n" +
            "            \"rating\": 4.2,\n" +
            "            \"reference\": \"CmRRAAAAHx2PbuGXYsvqiNrmTC46uTSh8KEcEUisuJJ5LnbixWY7_FzpYVnscEILnVjh8cq-kdXxCnUliBB5Kr91aFZ8hWmIJZjMPSOD8fIYQ79YqSU7IU-l5_I0RSfnLx-64MBvEhDy8vYIK9049r8ZEnao5S3mGhSFTd0wsu0iSFjpXWdDMcmGCMlgBQ\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Floda stationsväg 1G, Floda\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.8030946,\n" +
            "                    \"lng\": 12.3647509\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.8045431802915,\n" +
            "                        \"lng\": 12.3664688302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.80184521970849,\n" +
            "                        \"lng\": 12.3637708697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"f7c9b459180aa988a1afba4e22af293ba2c34dd9\",\n" +
            "            \"name\": \"Pizzeria Portobello\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 4032,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/101025400140370027754/photos\\\">Gamers YT</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAifcgQpr4gIOTK7VWWoD02Lj5uYJ6hz1F-kSmFQDbqp3qF-Oo_ZTjAIV_6GNMH1R9HoeX9lQTF9V3Ja9JriYBs1-wwmycryFfVbzgoUFFDfEa4LczcFlAkrE_j7qoUZ72EhD2acr3LAbRaUbqSAj_2mL8GhQQknKoTL_CdQ7eNKiOG0nQZi6QRQ\",\n" +
            "                    \"width\": 3024\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJ1f3002dWRUYRxD8dhynWGXI\",\n" +
            "            \"rating\": 4.2,\n" +
            "            \"reference\": \"CmRRAAAAOzrpOKcTnrgr1moB_nqGumoZUyHeGo94DEVdZ1QzZFNudRTNt-3MdAsEUP1U7ambYJT_m-GpnHJ0x3Uk7Mi46hImPkQ1fnNWrHVq-hxPUvmLuw_qhuW1jw28ffatv6vYEhBGkn66zte2NDvLtC5UcEK-GhRIly9anOBUckTr-YLXpb12uXZN4g\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Brovägen 38, Floda\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.77518989999999,\n" +
            "                    \"lng\": 12.2771445\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.7764407302915,\n" +
            "                        \"lng\": 12.2783253302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.77374276970849,\n" +
            "                        \"lng\": 12.2756273697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"8fd490d4b44d5a6001ecd217e6a03f6c0ee4bccc\",\n" +
            "            \"name\": \"Pizzeria San Remo\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 2160,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/114563057076197811157/photos\\\">Ludvig Lagerfors</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAUQ6qNLOWyxl_VtnTEbOosgqu7jtBZ1Km56HXLcihqt5jrHhsXszYsFaL7IGcnfuoOeNHeTgi26EmWHfOi4Pviz129EhuivmDhCkHuktZT4vqTorqLj7Bi12tuOAlQI3rEhCaa1dXcilHB9_QVBa-jDDsGhQvoBJm5zoA9YuuzJakyUt1xyETSw\",\n" +
            "                    \"width\": 3840\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJyeRmOXX4T0YRfXT15sVyKNE\",\n" +
            "            \"rating\": 4.4,\n" +
            "            \"reference\": \"CmRSAAAAiT8eok39WECHSxAs6nv3578mLJPmONmM_1SQxPxq2Ac1s1dQIbL7R-TJdk7NRcbrf1CJRoqwINJejdaUXSXMGP9PCXBBDtaS5muPHptD1GSIcwJ-ZI5rUOqel6YNQgxsEhCUabE4L-lofHnTkGChoj6OGhT_l35oBcGYhnlm8FoUynXbQijmsQ\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Pomonavägen 4, Lerum\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.77043450000001,\n" +
            "                    \"lng\": 12.2719895\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.77174458029151,\n" +
            "                        \"lng\": 12.2733351802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.7690466197085,\n" +
            "                        \"lng\": 12.2706372197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"fb5c6ba90a15035fda2b9cff263c1e1e6389c295\",\n" +
            "            \"name\": \"Pizzeria Ferrari\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 3024,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/112762622792526120142/photos\\\">Eva Eckersberg</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAATmvgqY9l1c3CHqnFkgjbN8BOIAQrQ1PcXTOXGC1bIXP5jVIL4ul7MTP-0QigbzzpS3sLA1hgzCFXDWneoXrsWtDZpLQ4gdur77wnwQ9e21XbHC8lROVaRLX3UILiGs9eEhB2xyEbfnB1RxuWAI160RVHGhR0nmHujZ2y7ZjTZOZuw3wcbBPtfg\",\n" +
            "                    \"width\": 4032\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJaRP-uQz4T0YRfcfTP2B_7J8\",\n" +
            "            \"rating\": 4.2,\n" +
            "            \"reference\": \"CmRSAAAApfKa4ivlG1Wtlx7wtOGDycUd9oY-qgbgMyg6JduyGK-uL7CvV86Z4JD4pPYKHwltpO38_dIv7g-i6Sbuyj8nKzQFK7fbHDhJKPdFfsRq3j3VAIgclDeFUGqoEOe6bDk0EhD0peGaiDq0WNuuCiCVzAAbGhRqj5273bZ35oTQavhFTmuxkebMcg\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Brobacken 10, Lerum\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.7704422,\n" +
            "                    \"lng\": 12.2608284\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.77189883029151,\n" +
            "                        \"lng\": 12.2621456802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.76920086970849,\n" +
            "                        \"lng\": 12.2594477197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"ab888fc3982d730f76beb1e41511f114e52016d1\",\n" +
            "            \"name\": \"Pizzeria Capri\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 1334,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/113660586590601338560/photos\\\">Bewar Mousa</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAT_XOsVYU2ezCaZUrNrtL05-r4kod6aglMjL3cNhwjY74PIAfKW_1kWXWsvDiCYGH9VO50ISc7Jpnx4-hOBW1fp9rWfFAw1k_xfc_vLrLc7d5_o8sLbXzro93evINk2GYEhBbQfiPgHn_O1UqeWDVJAGhGhSNRZ-rEXT8Bx7qvaWJ4mzPvWM9jw\",\n" +
            "                    \"width\": 750\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJlSef7w74T0YRdWdzC0nVpBY\",\n" +
            "            \"rating\": 3.5,\n" +
            "            \"reference\": \"CmRRAAAAnSbQirZfdVT7FFtfHZPXqzNrbrcmPKxurev7j2KyhIBTIOCE5voxERbu_g8kjCJ9Gc7jaGOEJtSGKszYX1u1cAd1_XkcqfztUb9CvHCuhJl0gaQKnyd_DqGu03mdtb8XEhA--rMt3sKgeiEMn_mPSqCTGhSrhCcAc4JQflkNqjb8CCYYP5cqSQ\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"443 31, Frödings allé 28, Lerum\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.80447849999999,\n" +
            "                    \"lng\": 12.168735\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.80595973029151,\n" +
            "                        \"lng\": 12.1699655302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.80326176970849,\n" +
            "                        \"lng\": 12.1672675697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"67d1f344efc5d0a90e8cf1b20fabd055913f790a\",\n" +
            "            \"name\": \"Pizzeria Arman Place\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 4032,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/101450423006855738450/photos\\\">Anders Blom</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAub7ogt_Mp3tIfMC4z8U8lQqLsLYm49UG__ZiIHv4i4VvBUpz8VXFxW7cNtXI_fr3XP_DCRUubLdg3uQxQH-6J21pVX1sSayF4hsNi-09ygJyAFQPWFnWU_qNLJ6UHnDcEhAo5SgDi8JmoJzisJYvn1nXGhTqkCsvgwMi2obvzYQMMzZHd20jsA\",\n" +
            "                    \"width\": 3024\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJhSlUgI5YRUYRu3IifXDJq-Q\",\n" +
            "            \"rating\": 4.3,\n" +
            "            \"reference\": \"CmRSAAAAyjMw88GuD2vHtbb7O9Er3EbqnAhuz0Ma1U3KKY8ksmd7qm8d52YZxMT-ZwtoAiYolmOEDJL4GGKWnk-c-W0a6VO7qjMSex2S3BbgFSS0BTgwjyQcEImMWTTxMxaKfb2cEhBtDwljH5mrcoA85cHFSKhPGhQZjbeqo5lahj7yAcSmVsCMypUT8w\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Lerumsvägen 27, Olofstorp\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.8175937,\n" +
            "                    \"lng\": 12.4187914\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.8189591302915,\n" +
            "                        \"lng\": 12.4206730802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.81626116970848,\n" +
            "                        \"lng\": 12.4179751197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"44c0d5e3e7c4957ae5f26b38a59f4b857fba25d7\",\n" +
            "            \"name\": \"Rooster Pizzeria\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 2976,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/114721127398547047399/photos\\\">Nadja Madorski</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAA5ZVORVafiNAPxVUu2Blv9hcrusC7HuiO6kTeVc-_23NEVg2q4j9nNPmgpENCx-inVUmzskf8V4KueQoZJyXMzcyPnDV21IrKi5WbPb3yNbbi7M9o1TntJqKpYNilY56UEhAJEeH8QyVUx9BUYK8Yru0eGhS5oPYkwKTgh_ilVKPWTC9mz90Bzg\",\n" +
            "                    \"width\": 3968\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJHQI3sy9URUYRbZAwoZQ3gts\",\n" +
            "            \"rating\": 3.6,\n" +
            "            \"reference\": \"CmRSAAAAdgotJuhko6El5N4Ps2xsRTRUWNNwr5OiUlnDqUEPoQRxXIfTezfJcHLuutJj6dQHNOlTit0MW7JOhB7gLaoDNiw-OxAkLUs6jafJe9npkx8FWI97-Y865Y-WUMKNC-sZEhAokbA8-M__-hkvBopTOl5pGhQ5dm81fvzGQVP3AQ37SZdVaPZV1g\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Volrath Bergs väg 3, Tollered\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.913771,\n" +
            "                    \"lng\": 12.3527571\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.9154613302915,\n" +
            "                        \"lng\": 12.3560418\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.91276336970849,\n" +
            "                        \"lng\": 12.3516622\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"0e3a82489e4fb5c3cf437deaa0f5d10d54f1e1f4\",\n" +
            "            \"name\": \"Sjöviks Pizzeria\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"place_id\": \"ChIJHSQ_41tQRUYRbVwwPkV4FTs\",\n" +
            "            \"rating\": 4,\n" +
            "            \"reference\": \"CmRRAAAAAPY8vhl8VHpuslGM5qrsdvWyeT4CAFCOLXpfyzoexNhs8VARlEpLY6Uz86Goh2sJ3sPUf4i7qvnThnjy7GgfkPTUDMcL4olWUjgUJt57OacaTmGD163ujkPDYSioSRVLEhBioa15zY24qK1t0PXgkXlDGhQXGkuPpp8zMlKT9UuIpIpiqsZ1jA\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Hampes väg 35, Sjövik\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.7979714,\n" +
            "                    \"lng\": 12.1462126\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.79937533029151,\n" +
            "                        \"lng\": 12.1476175802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.7966773697085,\n" +
            "                        \"lng\": 12.1449196197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"a26f4a7d87d0df5345eedb0e7b77200f032e78e4\",\n" +
            "            \"name\": \"Pizzeria Bella\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 1836,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/112565938702284910612/photos\\\">Leszek Zakrzewski</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAABpT2KP-XbV8SfM5r2YRFkmIjX65ig2HHy32FhNfmDz2i6tNlaAOGcsTc4vkAVhT1EVYYX5588iLBlpbvH1CIyEUp48tXAW2-Kb6Tg7OWGK1780LEY85Bd1kY4Y8V_DS0EhDnys-sm09iKmLXnAyoKkP8GhRevvJ12Guv7WXM5HEXjBRe_fjlBQ\",\n" +
            "                    \"width\": 3264\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJ449x95hYRUYRIyDxB-VhUN4\",\n" +
            "            \"rating\": 4.3,\n" +
            "            \"reference\": \"CmRSAAAAxpMIZi8QugQDSIpRib_rO9a6tAJtHZjOb5KimucM_mbjWm9qT_RZ9di64b9ketMmLSKvB253cimqiFbKXE52f83D9VZTxcxbYiTAGhSgLZflgrAmVze866V33j4oo0GvEhDnBOBwao6qgwlroDmBWkXpGhRApOR0FwbCs6zWUzUsFuBszrtDrg\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Björredsvägen 1, Olofstorp\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.75160799999999,\n" +
            "                    \"lng\": 12.258878\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.75302758029149,\n" +
            "                        \"lng\": 12.2604381802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.75032961970848,\n" +
            "                        \"lng\": 12.2577402197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"878cca7f747b242c1a84e51c675165da0303b716\",\n" +
            "            \"name\": \"Pizzeria Enzo\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 1920,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/110630560870244155009/photos\\\">Sany Peol</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAA7KBfpqCPlfasnwU6qVctkDSw949AkLMkvWKmFlVyeKkJtt2n5TlJ_cIgtH-JNDYzmhUH7AofPmmADe-ZWfr701eQc085pipbi-aLSvBbWPMVc8MaNLpFKG6E5Ze7ZGeTEhDXraZw6i35NOx7ARa3dptlGhTxazmEcp4X2yCr42O4aAUt8CI31g\",\n" +
            "                    \"width\": 1080\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJ4cMW5D74T0YRhYwpxHUa6b4\",\n" +
            "            \"rating\": 3.9,\n" +
            "            \"reference\": \"CmRSAAAAXkvBRaz_VkyeeOEtqhy6fNorULa2iLII-SxLSP0xxhKy_UCQkB17M_StVcFXCzBdxnYFRs5PgsRR3EwQrd1YQ06toMRpKzy9wKaNyd_uzdZKIYDibTA5kk7cIyFLmLgoEhD4SdQ0bgWGhG-AWXWag0WBGhR3K98cPVQM49wAYMindth-ioEk6Q\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Ekollonvägen 115, Lerum\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.7459577,\n" +
            "                    \"lng\": 12.1750322\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.74733203029151,\n" +
            "                        \"lng\": 12.1763388302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.7446340697085,\n" +
            "                        \"lng\": 12.1736408697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"2b0a9477d75f722ee9e60740b6bde1ee57b5cb19\",\n" +
            "            \"name\": \"Safir pizzeria\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 3024,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/111018914128244189843/photos\\\">David Berg</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAW52fsrecnRcdwfkatMFk6xxfPe-cBQ4OYMpE5MhJ8pi1Zg3KxInhi7XygP9aJ3G1BQV3CW_L8GwrXVFeyG4Xj5cJ4g6jGwHd1cGDpK7_6rnf1OJ10ul6ChABAdFCXa3HEhCU6MyMnEJqw6rf_QGk0_c0GhQqiQzLdC4q3Oo2s1N-O-PJ4NWQPA\",\n" +
            "                    \"width\": 4032\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJ5QHrcKb3T0YRZAsle-lAjWU\",\n" +
            "            \"rating\": 3.8,\n" +
            "            \"reference\": \"CmRRAAAAT0weZBz6keG1EmW_3BmhZz88mav9Jx-Yr2O9kPLl_rFwzZ6GfvITkCd2orEttZljJw0WXjaMyBMZ_LBD5jBoOW9k_kXSDEZ8EXlkhelLbp9NrDTsV-6lnNnsiX52BBh5EhBKTGOmXb9j8Y0quR8G5EMnGhQpccW3cW4uNsdLsXnsZGgBu3Ab7w\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Jonseredsvägen 21, Jonsered\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.8041786,\n" +
            "                    \"lng\": 12.0682327\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.80553433029151,\n" +
            "                        \"lng\": 12.0693211302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.8028363697085,\n" +
            "                        \"lng\": 12.0666231697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"0ded0df004bb7180130694845c4f507e34b3551d\",\n" +
            "            \"name\": \"Rannebergens Pizzeria\",\n" +
            "            \"place_id\": \"ChIJWcomwmZfRUYRJDDwSq4mnAc\",\n" +
            "            \"rating\": 4,\n" +
            "            \"reference\": \"CmRRAAAAR_iignK7pBgpv2ZaYsO4tGs_1Lf_Xoc0jY4_NxmNZS7kXcPLL__j-2htRVQGX3Ov1w6eh6QdmeOGdoqgcd94w4aMVQ4pv7-AJlwVH8oecrVKDUIMFwS0N06jfdrwi17GEhCkmLVUm09lw5eN3Dxr0Z2BGhQHeG4lU7lrB25faO7vYaQX3u7Gbg\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Fjällblomman 9, Angered\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.774596,\n" +
            "                    \"lng\": 12.0623228\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.7758822802915,\n" +
            "                        \"lng\": 12.0637375302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.77318431970849,\n" +
            "                        \"lng\": 12.0610395697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"bb1eea4179af9038a651b01554966e4cd3badd19\",\n" +
            "            \"name\": \"Gunnilse Kebab Pizza Restaurang\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 640,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/117358361549764034835/photos\\\">Hafez Nokhas</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAA6nnxVUJia2I17i1e32CrrLWDkfnM0x3BKscEYo2YAk27E5_vSqJ5bipP_cbWPTwohB481M6qy5u2HIGwnfyk16YjdHkBVNYIU2JtFL201_vu8KSMPawS2BA7b4Ki7gXmEhCkqW5WQe6FJS3EnUY2iPFGGhTdYxE_SdLEcTW2ZiB_g7siEwk3ZA\",\n" +
            "                    \"width\": 480\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJXyYgIMD1T0YRiaNetzxrqOY\",\n" +
            "            \"rating\": 2.9,\n" +
            "            \"reference\": \"CmRSAAAAXAUbmYQUqEre2yKfhikYcb-LMsykEV7LBXCqvIJZma9Sz4WU5iYVMZ1UfG3EcPv92tHpAkbQPu6ZWknYXMdOpybO7ODsa3vqPLr-uweDKRULQ5R0rJRIyAx4EJW1tlUqEhCb6TiBAeEiGlZDJs57ONAQGhQtMWAuiFkN4HXcV--pTNYO2pVikA\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Långavallsgatan 8, Gunnilse\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.89296270000001,\n" +
            "                    \"lng\": 12.0458252\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.89436183029152,\n" +
            "                        \"lng\": 12.0470658302915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.8916638697085,\n" +
            "                        \"lng\": 12.0443678697085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"9294df0c34d5a3d7072692acfca4c199cbf3bbe5\",\n" +
            "            \"name\": \"Pizzeria Bella Mia AB\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 1200,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/102751562062352999304/photos\\\">biketommy999</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAIpCL-4Kw41OwQiyZnAIEspRQOaWTUgPX8n7MCMYfArajJmPcKCz1srSAMze4Lg7jyA4T1NZpoC1znP2_gnLa5NIFeDMk0MITRsgqUFhZO4sZHzxjGGebkBQT24z2fTHsEhAXdlUyWukQQE2NWO2FZ6TnGhSTeQ0fzxdrQ6lpiktLx6Ud8qUAuA\",\n" +
            "                    \"width\": 1600\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJ0xJq599dRUYRmMJWSHb3of8\",\n" +
            "            \"rating\": 3.5,\n" +
            "            \"reference\": \"CmRSAAAAKpqDv5C--TrabJzzwYu3MtN0foSbsUQtPmTGpTOxIpKZOgBJC4uV06bpl4KQaGosgJIPgbn0laREoRELqFu8xoGybNsl8Z4Aa-nVH_Ngb-kBehx7802GpBaVIsnhDikyEhD5qfB-MrS-bNYIEdo4ShpyGhReLT8-OaG5GFMzA5l_YYK9nLQs8Q\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Ale torg 10, Nödinge\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.80865340000001,\n" +
            "                    \"lng\": 12.0301989\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.81000238029152,\n" +
            "                        \"lng\": 12.03154788029151\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.80730441970851,\n" +
            "                        \"lng\": 12.0288499197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"14913533dd86a478fde9d38396f925102ea53bf1\",\n" +
            "            \"name\": \"Juventus Pizzeria\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 1920,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/110252213654887964187/photos\\\">Fadi Saffan</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAxESeuO9sOXwN--rNP1cDrZwnjMAmrhtM4HKBXuCVINYzcO_cWrlhxBUSrBc3Y6OVg4qSxySPuKVowJHcHiD3rWtRo90s_OjGptvMShOPFO99hd013pa6YqXf5C56kRhfEhDb6IpYeWtabXmi7n2lx7J1GhQmiz4vmvxvQ0dHec12P4RR0st4IA\",\n" +
            "                    \"width\": 1080\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJCb1eb4RfRUYRg-8D84-_G6I\",\n" +
            "            \"rating\": 4.4,\n" +
            "            \"reference\": \"CmRSAAAAS8OuumnDQRC51n6XFzq8G24pvMAGKnupcwLAs6C3blGPq5eqovvTFtTgi9Nexhde3Ahoq8QVybwkyPRZc6zrmy9HBNM76fT66xx6GnLx0xv6o0ObQ1BMBscuquPA_s4DEhD9LlDKr3VBEqxt9bhOXrjjGhRQpuiFp-IZbSCk1jk7wFXgfkpgBA\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Saffransgatan, Angered\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"geometry\": {\n" +
            "                \"location\": {\n" +
            "                    \"lat\": 57.7256842,\n" +
            "                    \"lng\": 12.1288267\n" +
            "                },\n" +
            "                \"viewport\": {\n" +
            "                    \"northeast\": {\n" +
            "                        \"lat\": 57.72703318029151,\n" +
            "                        \"lng\": 12.1301756802915\n" +
            "                    },\n" +
            "                    \"southwest\": {\n" +
            "                        \"lat\": 57.72433521970849,\n" +
            "                        \"lng\": 12.1274777197085\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
            "            \"id\": \"c4d7fd4c40569c04d56080fd3a6f2caaa8f6e838\",\n" +
            "            \"name\": \"Furlunds pizzeria\",\n" +
            "            \"opening_hours\": {\n" +
            "                \"open_now\": false,\n" +
            "                \"weekday_text\": []\n" +
            "            },\n" +
            "            \"photos\": [\n" +
            "                {\n" +
            "                    \"height\": 3024,\n" +
            "                    \"html_attributions\": [\n" +
            "                        \"<a href=\\\"https://maps.google.com/maps/contrib/117035080864969599207/photos\\\">Tugra Can</a>\"\n" +
            "                    ],\n" +
            "                    \"photo_reference\": \"CmRaAAAAfVrlcgqbO_5_mKCQmcfVepeac1oAI5ZS3kpiJ1b99XM2thK805hpvpujRyoyqLS4Y-FAOliKLtip_BUuYgyvj50wUb8dUtT0O0Z5rSlg1l1A67xdwzal8aMegtt1BLUTEhDjVUz5zdInnPDgGH1Z61ZMGhQYqX3IyYg7kCgZQaDeAL5FQRRnVQ\",\n" +
            "                    \"width\": 4032\n" +
            "                }\n" +
            "            ],\n" +
            "            \"place_id\": \"ChIJJxN4Rub2T0YRGjajvrTd8A0\",\n" +
            "            \"rating\": 4.3,\n" +
            "            \"reference\": \"CmRRAAAA4FcISuX5dj4wdzuLxt4KHA3Ff0Y8NJzY4nKmhtBzwuF02DFP9ZdBfqjAzz_GQKUE49LABFQhP9y70Emw3YtMNLg7R2dZH6Qp_qbaMhaMmS64qpyFd4pzqEasbfRmnYBNEhBgTQyHUFqSjfUhK8eLJHlyGhSAkguKNJKtZMai4FpAYBYdgukmCQ\",\n" +
            "            \"scope\": \"GOOGLE\",\n" +
            "            \"types\": [\n" +
            "                \"restaurant\",\n" +
            "                \"food\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"establishment\"\n" +
            "            ],\n" +
            "            \"vicinity\": \"Furulund Centrum, Partille\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"status\": \"OK\"\n" +
            "}";



}
