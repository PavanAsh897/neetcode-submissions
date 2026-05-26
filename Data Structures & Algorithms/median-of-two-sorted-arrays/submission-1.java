class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int A[]= nums1;
        int B[]=nums2;
        int total =A.length+B.length;
        int half= total/2;
        if(B.length<A.length){
            int [] t =A;
            A=B;
            B=t;
        }
        int l=-1,r=A.length-1;
        while(l<=r){
            int i=l+(r-l)/2;
            int j= half-i-2;
            int ALeft=i>=0?A[i]:Integer.MIN_VALUE;
            int ARight=i+1<A.length? A[i+1]: Integer.MAX_VALUE;
            int BLeft=j>=0?B[j]:Integer.MIN_VALUE;
            int BRight=j+1<B.length? B[j+1]: Integer.MAX_VALUE;
            if(ALeft<=BRight && BLeft<=ARight){
                if(total%2!=0){
                    return Math.min(ARight,BRight);
                }else{
                    return (Math.max(ALeft,BLeft)+Math.min(ARight,BRight))/2.0;
                }
            }
            else if(ALeft>BRight){
                r=i-1;

            }else{
                l=i+1;
            }
        }
        return -1;
    }
}
