package Entity;

public class stack {
	private String[] data;
	private int maxSize;
	public int top = -1;
	
    //��ʼ��ջ
    public stack(int maxSize) {
        this.maxSize=maxSize;
        data = new String[maxSize];
        this.top=-1;
    }
    
    //�ж�ջ�Ƿ�Ϊ��
    public boolean isEmpty() {
        return (top==-1);
    }
    
    //�ж�ջ�Ƿ��Ѿ�����
    public  boolean isFull() {
        return (top==maxSize-1);
    }
    
    //ѹջ
    public boolean push(String value) {
        if(isFull()) {
            return false;
        }
        top++;
        data[top]=value;
        return true;
    }
    
    
    //ȡ��ջ��Ԫ��
    public String pop() {
        if(isEmpty()) {
            return null;
        }
        String tmp=data[top];
        data[top]=null;
        top--;
        return tmp;
    }
    
    //ջ������
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
    
    //============���Դ���============
    public static void main(String[] args) {
        stack as=new stack(4);
        as.push("anhui");
        as.push("shanghai");
        as.push("beijing");
        as.push("nanj");
        as.inversion();
        //����ջ�Ѿ����˵����
        System.out.println(as.push("aa"));
        for(int i=0;i<4;i++) {
            System.out.println(as.pop());
        }
        System.out.println(as.isEmpty());
    }
        
	/*public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String[] s = new String[10];
		s[0]=""+123+"���";
		s[0]="hello";
		s[0]=null;
		System.out.println(s[0]);
	}*/

}
