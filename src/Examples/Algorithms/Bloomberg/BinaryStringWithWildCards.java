package Examples.Algorithms.Bloomberg;
/*
Given a string containing of ‘0’, ‘1’ and ‘?’ wildcard characters, generate all binary strings
that can be formed by replacing each wildcard character by ‘0’ or ‘1’.
For exmaple:
Input str = "1??0?101"
Output:
        10000101
        10001101
        10100101
        10101101
        11000101
        11001101
        11100101
        11101101
 */

public class BinaryStringWithWildCards {
    public void print(char[] str, int index){
        if (index == str.length) {
            System.out.println(str);
            return;
        }
        if (str[index] == '?'){
            str[index] = '0'; // case 1
            print(str, index+1);

            str[index] = '1'; // case 2
            print(str, index+1);

            str[index] = '?'; // 回溯
        } else
            print(str, index+1);
    }
}
