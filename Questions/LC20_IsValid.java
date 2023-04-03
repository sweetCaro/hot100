import java.util.Stack;

public class LC20_IsValid {
    public static boolean isValid(String s){
        boolean result = true;
        Stack<Character> stack = new Stack<Character>();//记住栈的定义方式
        for(int i = 0; i < s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='['||ch=='{'){//如果时左括号就入栈
                stack.push(ch);
            }
            else{//如果是右括号
                if(!stack.isEmpty()){//大条件：栈此时非空，里面已经存有一些左括号
                    if(ch==')'){//如果是小右括号
                        if(stack.pop()!='('){//弹出栈顶元素看是不是小左括号，如果不是，直接标记结果为false
                            result = false;
                        }
                    }
                    if(ch==']'){
                        if(stack.pop()!='['){
                            result=false;
                        }
                    }
                    if(ch=='}'){
                        if(stack.pop()!='{'){
                            result=false;
                        }
                    }
                }
                else//此时栈是空的，即栈里面没有左括号，而此时碰到的字符是右括号，结果为false
                    result=false;
            }
        }
        if(!stack.isEmpty())    result=false;
        return result;
    }
    public static void main(String[] args){
        String s = "{[()]";
        System.out.println(isValid(s));
    }
}
