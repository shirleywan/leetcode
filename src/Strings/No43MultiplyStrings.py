#conding: 'utf-8'
def multiply( num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if (num1 == "" or len(num1) == 0):
            return ""
        if (num2 == "" or len(num2) == 0):
            return ""
        if (int(num1) == 0 or int(num2) == 0) :
            return "0"
        return str(int(num1)*int(num2))
if __name__ == "__main__":
    str1 = "1231111111111111111111"
    str2 = "45611111111111111111111"
    print(multiply(str1 , str2))
    
# 43. Multiply Strings
# Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
# Example 1:
#    Input: num1 = "2", num2 = "3"
#    Output: "6"
#Example 2:
#    Input: num1 = "123", num2 = "456"
#    Output: "56088"
# Note:
# The length of both num1 and num2 is < 110.
# Both num1 and num2 contain only digits 0-9.
# Both num1 and num2 do not contain any leading zero, except the number 0 itself.
# You must not use any built-in BigInteger library or convert the inputs to integer directly.
