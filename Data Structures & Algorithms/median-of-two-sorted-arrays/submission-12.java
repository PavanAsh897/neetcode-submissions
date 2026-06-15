class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] A=nums1;
        int B[] =nums2;
        int total =A.length+B.length;
        int half =(A.length+B.length)/2;
        if(B.length<A.length){
            int [] t= A;
            A=B;
            B=t;
        }
        int l=-1, r=A.length-1;
        while(true){
            int i =Math.floorDiv(l+r,2);
            int j=half-i-2;
            int Aleft= (i>=0&&i<A.length)? A[i]:Integer.MIN_VALUE;
            int Aright=i+1<A.length? A[i+1]:Integer.MAX_VALUE;
            int Bleft=(j>=0 && j<B.length)? B[j]:Integer.MIN_VALUE;
            int Bright=j+1<B.length?B[j+1]:Integer.MAX_VALUE;
            if(Aleft<=Bright && Bleft<=Aright){
                if(total%2!=0){
                    return Math.min(Aright,Bright);
                }
                return (Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.0;

            }else if(Aleft>Bright){
                r=i-1;
            }else{
                l=i+1;
            }
            

        }

   
    
    }
}