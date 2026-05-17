class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        Map<Character, Character> closedMap= new HashMap<>();
        closedMap.put(')','(');
        closedMap.put('}','{');
        closedMap.put(']','[');
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && closedMap.get(c)==stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
return stack.isEmpty();
        
    }
}
