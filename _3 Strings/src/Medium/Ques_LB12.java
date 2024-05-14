package Medium;

public class Ques_LB12 {

    //Ques : Validate IP Address.........                                            (Leet code Ques no.- 468)


    //Approach 1 : Simple Approach....Efficient solution.......
    class Solution_1 {
        public String validIPAddress(String queryIP)
        {
            int count1 = 0;
            int count2 = 0;
            // Count the number of '.' abd ':' in the string

            for(char c : queryIP.toCharArray()) {
                if(c == '.')
                    count1++;
                if(c == ':')
                    count2++;
            }
            if(count1 == 3) {
                String[] query = queryIP.split("\\.");
                if(query.length == 4) {
                    if(validIP4(query))
                        return "IPv4";
                    return "Neither";
                }
            }
            if(count2 == 7) {
                String[] query6 = queryIP.split("\\:");
                if(query6.length == 8) {
                    if(validIP6(query6))
                        return "IPv6";
                    return "Neither";
                }
            }
            return "Neither";
        }
        // Check whether it's valid IPv4
        private boolean validIP4(String[] query)
        {
            for(String str : query) {
                if(str.startsWith("0") && str.length() > 1)
                    return false;
                try {
                    int num = Integer.parseInt(str);
                    if(num < 0 || num > 255)
                        return false;
                }
                catch(NumberFormatException e) {
                    return false;
                }
            }
            return true;
        }
        // Check whether it's valid IPv6
        private boolean validIP6(String[] query)
        {
            for(String str : query) {
                if(str.length() > 4 || str.length() <= 0)
                    return false;

                for(char c : str.toCharArray())
                {
                    if((c >= 'a' && c <= 'f') || (c >= 'A' && c <='F') || (c >= '0' && c <= '9'))
                        continue;

                    return false;
                }
            }
            return true;
        }
    }


    //Approach 2 :
    class Solution_2 {
        public String validIPAddress(String IP)
        {
            if(IP.length()==0)
                return "Neither";

            if(IP.indexOf(".")>=0)
                return validateIPV4(IP);

            if(IP.indexOf(":")>=0)
                return validateIPV6(IP);

            return "Neither";
        }

        private  String validateIPV4(String ip){
            // step 1
            if(ip.charAt(0)=='.' || ip.charAt(ip.length()-1)=='.')
                return "Neither";

            //step 2
            String[] component = ip.split("\\.");

            //step 3
            if(component.length != 4)
                return "Neither";

            //step 4
            for(String comp : component)
            {
                if(comp.length()==0 || comp.length()>3 || (comp.charAt(0)=='0' && comp.length()>1))
                {
                    return "Neither";
                }

                //step5
                for(char ch:comp.toCharArray())
                {
                    if(ch<'0' || ch>'9')
                        return "Neither";
                }

                //step6
                int num=Integer.parseInt(comp);
                if(num<0 || num>255)
                    return "Neither";

            }

            return "IPv4";
        }

        private String validateIPV6(String ip)
        {
            if(ip.charAt(0)==':' || ip.charAt(ip.length()-1)==':')
                return "Neither";

            String[] component = ip.split(":");

            if(component.length!=8)
                return "Neither";

            for(String comp:component)
            {
                if(comp.length()==0 || comp.length()>4)
                    return "Neither";

                for(char ch:comp.toLowerCase().toCharArray())
                {
                    if((ch<'0' || ch>'9') && (ch!='a' && ch!='b' && ch!='c' && ch!='d' && ch!='e' && ch!='f'))
                    {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }


    //Approach 3 :
    class Solution {
        public String validIPAddress(String queryIP)
        {
            String []arr1 = queryIP.split("\\.");
            String []arr2 = queryIP.split("\\:");

            if(queryIP.length() > 0)
            {
                char ch1 = queryIP.charAt(0);
                char ch2 = queryIP.charAt(queryIP.length()-1);

                if(ch1=='.' || ch1==':' || ch2=='.' || ch2==':')
                {
                    return "Neither";
                }
            }

            if(arr1.length == 4)
            {
                for(int i=0 ; i<4 ; i++)
                {
                    String s = arr1[i];
                    if(s.length()>1 && s.charAt(0)=='0')
                    {
                        return "Neither";
                    }
                    try{
                        int snum = Integer.parseInt(s);

                        if(snum<0 || snum>255){
                            return "Neither";
                        }
                    }
                    catch(Exception e){
                        return "Neither";
                    }
                }
                return "IPv4";
            }
            else if(arr2.length == 8)
            {
                for(int i=0 ; i<8 ; i++)
                {
                    String s = arr2[i];
                    if(s.length()<1 || s.length()>4)
                    {
                        return "Neither";
                    }
                    for(int j=0 ; j<s.length() ; j++)
                    {
                        char ch = s.charAt(j);
                        int val = (int)ch;

                        if((val>=48 && val<=57)||(val>=65 && val<=70)||(val>=97 && val<=102))
                        {
                            continue;
                        }else{
                            return "Neither";
                        }
                    }
                }
                return "IPv6";
            }
            else
            {
                return "Neither";
            }
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6"
                 if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

                 A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and
                 xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are
                 valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.

                 A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where :
                    1 <= xi.length <= 4

                 xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f')
                 and upper-case English letters ('A' to 'F').

                 Leading zeros are allowed in xi.
                 For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and
                              "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses,

                              while "2001:0db8:85a3::8A2E:037j:7334" and
                                    "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.




                    Example : 1
                    Input   : queryIP = "172.16.254.1"
                    Output  : "IPv4"
                    Explanation : This is a valid IPv4 address, return "IPv4".


                    Example : 2
                    Input   : queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
                    Output  : "IPv6"
                    Explanation : This is a valid IPv6 address, return "IPv6".


                    Example : 3
                    Input   : queryIP = "256.256.256.256"
                    Output  : "Neither"
                    Explanation : This is neither a IPv4 address nor a IPv6 address.

        * */
    }


}
