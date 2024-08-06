class Pair{

    int  value;
    String roman;

    Pair(int v, String r){
        this.value = v;
        this.roman = r;
    }
}

class Solution {

    public String intToRoman(int num) {
        
        Pair[] number = {
            new Pair(1, "I"),
            new Pair(5, "V"),
            new Pair(10, "X"),
            new Pair(50, "L"),
            new Pair(100, "C"),
            new Pair(500, "D"),
            new Pair(1000, "M"),
        };
        Map<Integer, String> map = new HashMap<>();

        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        int ten = 0;
    String ans = "";
    
    while(num > 0){

        int curr = num % 10;
        int mutiple = (int)Math.pow(10, ten);
        curr = curr *  mutiple;

        if(map.containsKey(curr)){
            ans = (map.get(curr) + ans);
        } else{
            String temp = "";
            int i = 6;
            while(i >= 0){
                Pair p = number[i];
                if(p.value <= curr){
                    temp =  temp + p.roman;
                    curr -= p.value;
                    if(curr == 0) break;
                } else {
                    i--;
                }
            }
            ans = temp + ans;
        }
        ten++;
        num = num / 10;
    }
    return ans;
        
    }
}



// Symbol	Value
// I	1
// V	5
// X	10
// L	50
// C	100
// D	500
// M	1000
// 4 (IV),
// 9 (IX),
// 40 (XL), 
// 90 (XC), 
// 400 (CD) 
// 900 (CM)
