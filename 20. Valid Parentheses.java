class Solution {
	boolean isValid(String str) {
	    // add your logic here
		Stack <Character> st = new Stack<>();
		for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else if(ch == ')' || ch == ']' || ch == '}'){
                if(st.size() == 0){
                    return false;
                }
                else if(st.peek() == '(' && ch == ')'){
                    st.pop();
                }
                else if(st.peek() == '[' && ch == ']'){
                    st.pop();
                }
                else if(st.peek() == '{' && ch == '}'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return (st.size() == 0);
	}
}
