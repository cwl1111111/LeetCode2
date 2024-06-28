package com.cai.demo1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Konglyu {
    public static void main(String[] args) throws IOException {


        String[] strings = {"K00280",
                "K00355",
                "K00432",
                "K00476",
                "K00624",
                "K00645",
                "K00699",
                "K00710",
                "K00727",
                "K00729",
                "K00741",
                "K00779",
                "K01081",
                "K01158",
                "K01273",
                "K01312",
                "K01370",
                "K01530",
                "K01587",
                "K01672",
                "K01679",
                "K01756",
                "K01769",
                "K02206",
                "K02273",
                "K02324",
                "K02332",
                "K02366",
                "K02539",
                "K02677",
                "K03098",
                "K03165",
                "K03283",
                "K03345",
                "K03376",
                "K03469",
                "K03479",
                "K03593",
                "K03914",
                "K03916",
                "K04001",
                "K04008",
                "K04178",
                "K04215",
                "K04231",
                "K04245",
                "K04256",
                "K04257",
                "K04265",
                "K04270",
                "K04279",
                "K04299",
                "K04312",
                "K04328",
                "K04402",
                "K04414",
                "K04437",
                "K04490",
                "K04515",
                "K04551",
                "K04592",
                "K04593",
                "K04594",
                "K04613",
                "K04622",
                "K04644",
                "K04846",
                "K04887",
                "K04906",
                "K04961",
                "K04963",
                "K04988",
                "K05045",
                "K05050",
                "K05051",
                "K05096",
                "K05122",
                "K05164",
                "K05204",
                "K05222",
                "K05266",
                "K05361",
                "K05398",
                "K05408",
                "K05414",
                "K05442",
                "K05482",
                "K05607",
                "K05637",
                "K05658",
                "K05665",
                "K05693",
                "K05701",
                "K06065",
                "K06087",
                "K06237",
                "K06449",
                "K06463",
                "K06467",
                "K06472",
                "K06498",
                "K06499",
                "K06511",
                "K06545",
                "K06553",
                "K06554",
                "K06560",
                "K06563",
                "K06565",
                "K06615",
                "K06634",
                "K06710",
                "K06712",
                "K06727",
                "K06745",
                "K06747",
                "K06749",
                "K06751",
                "K06752",
                "K06787",
                "K06788",
                "K06789",
                "K06830",
                "K06834",
                "K06846",
                "K06856",
                "K07374",
                "K07418",
                "K07426",
                "K07526",
                "K07665",
                "K07818",
                "K08022",
                "K08057",
                "K08080",
                "K08106",
                "K08396",
                "K08399",
                "K08453",
                "K08574",
                "K08592",
                "K08606",
                "K08627",
                "K08664",
                "K08770",
                "K08826",
                "K08834",
                "K08852",
                "K09105",
                "K09216",
                "K09228",
                "K09257",
                "K09326",
                "K09406",
                "K09427",
                "K09541",
                "K09677",
                "K10030",
                "K10064",
                "K10093",
                "K10100",
                "K10130",
                "K10279",
                "K10324",
                "K10357",
                "K10369",
                "K10377",
                "K10392",
                "K10402",
                "K10478",
                "K10645",
                "K10652",
                "K10737",
                "K10784",
                "K10785",
                "K10789",
                "K10848",
                "K10904",
                "K11247",
                "K11251",
                "K11252",
                "K11253",
                "K11275",
                "K11446",
                "K11499",
                "K11797",
                "K11836",
                "K11846",
                "K11850",
                "K11855",
                "K12006",
                "K12009",
                "K12012",
                "K12183",
                "K12354",
                "K12382",
                "K12471",
                "K12560",
                "K12663",
                "K12798",
                "K12799",
                "K12800",
                "K12801",
                "K12804",
                "K12837",
                "K12854",
                "K12879",
                "K13023",
                "K13044",
                "K13072",
                "K13161",
                "K13356",
                "K13517",
                "K13675",
                "K13708",
                "K13755",
                "K13868",
                "K13907",
                "K13957",
                "K13963",
                "K14026",
                "K14216",
                "K14217",
                "K14388",
                "K14480",
                "K14530",
                "K14589",
                "K14614",
                "K14639",
                "K14808",
                "K14819",
                "K14829",
                "K14960",
                "K15049",
                "K15076",
                "K15185",
                "K15208",
                "K15255",
                "K15259",
                "K15260",
                "K15279",
                "K15376",
                "K15433",
                "K15442",
                "K15485",
                "K15689",
                "K16059",
                "K16175",
                "K16463",
                "K16464",
                "K16493",
                "K16494",
                "K16495",
                "K16496",
                "K16497",
                "K16499",
                "K16506",
                "K16631",
                "K16634",
                "K16662",
                "K16668",
                "K16669",
                "K16803",
                "K16826",
                "K16827",
                "K16912",
                "K16949",
                "K17270",
                "K17332",
                "K17341",
                "K17346",
                "K17349",
                "K17387",
                "K17388",
                "K17592",
                "K17608",
                "K17726",
                "K17854",
                "K17859",
                "K18196",
                "K18402",
                "K18409",
                "K18585",
                "K18592",
                "K18626",
                "K18668",
                "K18670",
                "K18684",
                "K18709",
                "K18729",
                "K18808",
                "K19346",
                "K19347",
                "K19363",
                "K19410",
                "K19484",
                "K19619",
                "K19625",
                "K19759",
                "K19876",
                "K19926",
                "K19977",
                "K19999",
                "K20032",
                "K20175",
                "K20180",
                "K20198",
                "K20298",
                "K20361",
                "K20395",
                "K20478",
                "K20493",
                "K20865",
                "K20910",
                "K21097",
                "K21125",
                "K21754",
                "K21847",
                "K21851",
                "K21871",
                "K21889",
                "K22244",
                "K22371",
                "K22544",
                "K22593",
                "K22594",
                "K22611",
                "K22614",
                "K22656",
                "K22758",
                "K22762",
                "K22790",
                "K22870",
                "K23014",
                "K23116",
                "K23194",
                "K23204",
                "K23220",
                "K23221",
                "K23222",
                "K23379",
                "K23483",
                "K23593",
                "K23607",
                "K23869",
                "K23934",
                "K24144",
                "K24220",
                "K24261",
                "K24274",
                "K24356"
        };
        String regex1 = "(<td class=\"data1\" bgcolor=\"#FFFFFF\">)([^\\.].+[^\\.])(</td>)";
        String regex2 = "map\\d{5}";
        String urlString = null;
        HashMap<String, String> hashMap = new HashMap<>();
        int index = 1;
        for (String string : strings) {
            System.out.println("正在进行第"+index+"次");
            index++;
            urlString = "https://www.kegg.jp/kegg-bin/search_pathway_text?map=map&keyword="+string+"&mode=1&viewImage=true";
            StringBuilder sb = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            int ch;
            while ((ch = inputStreamReader.read()) != -1) {
                sb.append((char) ch);

            }
            inputStreamReader.close();


            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();

            arrayList2 = getData1(sb.toString(),regex1);
            arrayList3 = getData2(sb.toString(),regex2);

            ArrayList<String> arrayList5 = new ArrayList<>();
            StringBuilder sb2 = new StringBuilder();
            if(arrayList2.size()==arrayList3.size()) {
                for (int i = 0; i < arrayList2.size(); i++) {
                    sb2.append(arrayList2.get(i)+"("+arrayList3.get(i)+")").append("      ") ;
                }
            }else{
                arrayList5.add(string);
            }
            hashMap.put(string, sb2.toString());
            System.out.println(hashMap.toString());
            System.out.println(arrayList5.toString());
        }
        System.out.println(hashMap.toString());


    }
    public static ArrayList<String> getData1(String string,String regex){
        ArrayList<String> arrayList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
            String group = matcher.group(2);
            arrayList.add(group);
        }
        return arrayList;

    }
    public static ArrayList<String> getData2(String string,String regex){
        ArrayList<String> arrayList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
            String group = matcher.group();
            if(!arrayList.contains(group)){
                arrayList.add(group);
            }
            ;

        }
        return arrayList;

    }
}

