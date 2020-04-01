package Entity;

public class stack {
	private String[] data;
	private int maxSize;
	public int top = -1;
	
    //初始化栈
    public stack(int maxSize) {
        this.maxSize=maxSize;
        data = new String[maxSize];
        this.top=-1;
    }
    
    //判断栈是否为空
    public boolean isEmpty() {
        return (top==-1);
    }
    
    //判断栈是否已经满了
    public  boolean isFull() {
        return (top==maxSize-1);
    }
    
    //压栈
    public boolean push(String value) {
        if(isFull()) {
            return false;
        }
        top++;
        data[top]=value;
        return true;
    }
    
    
    //取出栈顶元素
    public String pop() {
        if(isEmpty()) {
            return null;
        }
        String tmp=data[top];
        data[top]=null;
        top--;
        return tmp;
    }
    
    //栈的逆置
    public void inversion() {
    	String[] s = new String[maxSize];
    	for(int i=0; i<=top; i++) {
    		s[i] = data[i];
    	}
    	for(int i=0; i<=top; i++) {
    		data[i] = s[top-i];
    	}
    }
    public void copy(stack s) {
    	  for(int j = 0; j<=top;j++)
    	   s.data[j] = data[j];
    	  s.top=top;
    	    }
    
    //============测试代码============
    public static void main(String[] args) {
        stack as=new stack(4);
        as.push("anhui");
        as.push("shanghai");
        as.push("beijing");
        as.push("nanj");
        as.inversion();
        //测试栈已经满了的情况
        System.out.println(as.push("aa"));
        for(int i=0;i<4;i++) {
            System.out.println(as.pop());
        }
        System.out.println(as.isEmpty());
    }
        
	/*public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] s = new String[10];
		s[0]=""+123+"你好";
		s[0]="hello";
		s[0]=null;
		System.out.println(s[0]);
	}*/

}
