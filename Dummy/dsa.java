import java.util.*;
class DSA{
      Scanner sc = new Scanner(System.in);
      int data;
      DSA next;
      DSA left;
      DSA right;
      
      void E1(int r,List<Integer> T){
            int temp=0;
            
            for(int i=0;i<r;i++){
                  temp=T.get(0);
                  for(int j=0;j<T.size()-1;j++){
                        T.set(j,T.get(j+1));
                  }
                  T.set(T.size()-1,temp);
            }
            
            for(int a:T){
                  System.out.print(a);
            }
      }
      
      String E2(int a,int b,int c,int d,int j){
            int r1=a;
            int r2=c;
            
            for(int i=0;i<j;i++){
                  r1+=b;
                  r2+=d;
            }
            
            if(r1==r2) return "YES";
            else return "NO";
      }
      
      String E3(int x,int y , int z){
            int CA,CB,MC;
            
            CA=Math.abs(z-x);
            CB=Math.abs(z-y);
            
            if(CB<CA) return "Cat B";
            else if(CA<CB) return "Cat A";
            else return "Mouse C";
      }
      
      void E4(int[] arr){
            List<Integer> l = new ArrayList<>();
            int temp=0,min=0,ind=0;
            /*for(int i=0;i<arr.length;i++){
                  for(int j=0;j<arr.length - 1;j++){
                        if(arr[j] > arr[j+1]){
                              temp = arr[j];
                              arr[j] = arr[j+1];
                              arr[j+1] = temp;
                        }
                  }
            }*/
            
            for(int i=0;i<arr.length - 1;i++){
                  min = i;
                  for(int j=i+1;j<arr.length - 1;j++){
                        if(arr[j] < arr[min]) min = j;
                  }
                        temp = arr[i];
                        arr[i] = arr[min];
                        arr[min] = temp;
            }
                  l.add(arr[0]);
            for(int k=0;k<arr.length;k++){
                 if(arr[k] > l.get(ind)){
                 l.add(arr[k]);
                 ind++;
                 }
            }
            
            for(int a:l){System.out.print(a);}
      }
      
      void q1(int arr[]){
            int target=11;
             for(int i=0;i<4;i++){
                  for(int j=i+1;j<5;j++){
                        if(arr[i] + arr[j] == target) System.out.println(i+" and "+(j));
                  }
            }
      }
      
      void q2(String input) {
        int n = input.length();
        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - i - 1)) {
                System.out.println("Not valid");
                return; 
            }
        }
        System.out.println("Valid");  
      }
      
            /*DSA(int data){
                  this.data=data;
                  this.next=null;
            }*/
      /*DSA q3(DSA p,int data){
            
            
            DSA newnode = new DSA(data);
            
            if(p == null){
                  return newnode;
            }
            
            DSA temp = p;
            while(temp.next != null){
                  temp = temp.next;
            }
            temp.next = newnode;
            return p;
      }*/
      
      int q4(int[] arr){
            int min=0,max=0,profit=0;
            for(int i= 1;i<arr.length;i++){
                  if (arr[min] > arr[i]) min = i;
                  else profit = Integer.max(profit,arr[i]-arr[min]);
            }
            return profit;
      }

      String q5(String input){
            int n = input.length();
            input = input.toLowerCase();
            StringBuilder s = new StringBuilder();
            for(int i=0;i<n;i++){
                  if(Character.isLetter(input.charAt(i))) s.append(input.charAt(i));
            }
            
            for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return "Not Palindrome!";
            }
            }
                return "Palindrome!"; 
      }
      
      
            DSA(int data){
                  this.data=data;
                  this.left=null;
                  this.right=null;
            }
      /*DSA q6(DSA root,int data){
            if(root == null) return new DSA(data);
            
            if(data<root.data){
                  root.left=q6(root.left,data);
            }else root.right=q6(root.right,data);
            
                  return root;
      }
      
       void inorder(DSA root) {
       DSA temp;
        if (root == null) return;
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
        
       }
       
       DSA invert(DSA root){
             if (root == null) return null;  

             DSA temp = root.left;
             root.left = invert(root.right);
             root.right = invert(temp);

              return root;
       }*/
      
      boolean q7(String a,String b){
            for(int i=0;i<a.length();i++){
                    if(b.contains(Character.toString(a.charAt(i))) == false) return false;
            }
            return true;
      }
      
      int q8(int[] arr,int target){
            int low=0,high=arr.length-1,mid;
            
            while(low<=high){
                  mid=low + (high-low) / 2;
                  if(arr[mid] == target) return mid;
                  else if(target < arr[mid]) high=mid-1;
                  else low=mid+1;
            }
            return -1;
      }
      
      void q9(int[][] arr){
            for(int r=0;r<arr.length;r++){
                  for(int c=0;c<arr.length;c++){
                        System.out.print(arr[r][c]);
                  }
                  System.out.println();
            }
            int sr=1,sc=1,newc=7;
            int oldc = arr[sr][sc];
            if(oldc == newc) return;
            
            for(int row=0;row<arr.length;row++){
                  if(arr[row][sc] == oldc) arr[row][sc] = newc;
            }
            
            for(int col=0;col<arr.length;col++){
                  if(arr[sr][col] == oldc) arr[sr][col] = newc;
            }
            
            for(int r=0;r<arr.length;r++){
                  for(int c=0;c<arr.length;c++){
                        System.out.print(arr[r][c]);
                  }
                  System.out.println();
            }
      }
      
            void inForQ10(DSA root){
                  if(root == null) return;
                  inForQ10(root.left);
                  System.out.print(root.data+" ");
                  inForQ10(root.right);
                  
            }
            
            int findAncestor(DSA root,int lData,int rData){
                  if(lData < root.data && rData < root.data) return findAncestor(root.left,lData,rData);
                  if(lData > root.data && rData > root.data) return findAncestor(root.right,lData,rData);
                  return root.data;
            }
            
      DSA q10(DSA root,int data){
            if(root == null) return new DSA(data);
            if(data < root.data) root.left = q10(root.left,data);
            else root.right = q10(root.right,data);
            
            return root;
      }
      
      
            void inForQ11(DSA root){
                  if(root == null) return;
                  inForQ11(root.left);
                  System.out.print(root.data+" ");
                  inForQ11(root.right);
            }
            
            int isBalanced(DSA root){
                  if(root == null) return 0;
                  int lheight = isBalanced(root.left);
                  int rheight = isBalanced(root.right);
                  
                  if(lheight == -1 || rheight == -1 || Math.abs(lheight - rheight)>1) return -1;
                  return Math.max(lheight,rheight) +1;
            }
            
      DSA q11(DSA root,int data){
            if(root == null) return new DSA(data);
            
            if(root.data < data) root.right = q11(root.right,data);
            else root.left = q11(root.left,data);
            return root;
      }
      
      
      
      public static void main(String[] args){
            DSA p = new DSA(-1);
            int arr1[] =new int[args.length];
            //String arr1[] =new String[args.length];
            for(int i=0;i<args.length;i++){
                  arr1[i]=Integer.parseInt(args[i]);
                  //arr1[i]=args[i];
            }
            
            /*int size = args.length / 3;
            int ind = 0;
            int[][] arr2d = new int[size][size];
                  for(int i=0;i<size;i++){
                        for(int j=0;j<size;j++){
                              arr2d[i][j] = Integer.parseInt(args[ind++]);
                        }
                  }*/
            
            List<Integer> T = Arrays.asList(1,2,3,4,5);
            //p.E1(2,T);
            
            //System.out.println(p.E2(1,2,3,4,4));
            
            //System.out.println(p.E3(2,1,3));
            
            //p.E4(arr1);
            
            
            //p.q1(arr1);
            
            //p.q2("{[()]}");
            
            //q3
           /*DSA head1=null,head2=null,merge=null,temp1=null;
           
            for(int i=0;i<args.length;i++){
                  if(i%2==0) head1=p.q3(head1,Integer.parseInt(args[i]));
                  else head2=p.q3(head2,Integer.parseInt(args[i]));
            }
            DSA temp = head1;
            while(temp != null){
                  System.out.print(temp.data);
                  temp = temp.next;
            }
            System.out.println();
            
            DSA temp2 = head2;
            while(temp2 != null){
                  System.out.print(temp2.data);
                  temp2 = temp2.next;
            }
            System.out.println();
            
            
            if(head1.data<head2.data){
                        merge=head1;
                        head1=head1.next;
                  }else{
                        merge=head2;
                        head2=head2.next;
                  }
                  
               temp1=merge;
            while(head1!=null && head2!=null){
                  if(head1.data<head2.data){
                        temp1.next=head1;
                        head1=head1.next;
                  }else{
                        temp1.next=head2;
                        head2=head2.next;
                  }
                  temp1=temp1.next;
                  
            }
            
                if (head1 != null) temp1.next = head1;
                if (head2 != null) temp1.next = head2;
                
              temp1=merge;
             while(temp1 != null){
                  System.out.print(temp1.data);
                  temp1 = temp1.next;
            }*/
           
           //q4
           //System.out.println(p.q4(arr1));
           
           //q5
           //System.out.println(p.q5("ace a car"));
           
           //q6
           /*DSA root = null;
           for(int i=0;i<args.length;i++){
                  root=p.q6(root,Integer.parseInt(args[i]));
           }
           p.inorder(root);
           System.out.println();
           p.invert(root);
           p.inorder(root);
           System.out.println();*/
           
           //q7
           //System.out.println(p.q7(arr1[0],arr1[1]));
          
           //q8
           //System.out.println(p.q8(Arrays.copyOfRange(arr1,0,arr1.length - 1),arr1[arr1.length - 1]));
           
           //q9
           //p.q9(arr2d);
            
           //q10
           DSA root = null;
           /*for(int i=0;i<args.length;i++){
           root = p.q10(root,Integer.parseInt(args[i]));
           }
           p.inForQ10(root);
           System.out.println();
           System.out.println(p.findAncestor(root,7,9));*/
      
          //q11
          for(int i=0;i<args.length;i++){
                root = p.q11(root,Integer.parseInt(args[i]));
          }
          p.inForQ11(root);
          System.out.println();
          System.out.println(p.isBalanced(root) != -1);
      
      
      }
}
