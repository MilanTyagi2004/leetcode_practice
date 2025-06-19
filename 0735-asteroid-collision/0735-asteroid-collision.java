class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer>  st = new Stack <>();

        for(int i=0;i<n;i++){
            boolean destroyed = false;
            while(!st.isEmpty()&&st.peek()>0 && asteroids[i]<0){
                if(st.peek()< -asteroids[i]){
                    st.pop();
                }else if(st.peek() == -asteroids[i]){
                    st.pop();
                   
                }
                destroyed = true;
                break;
            }
            if(!destroyed){
            st.push(asteroids[i]);
            }
        }
        int []result = new int [st.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i] = st.pop();
        }
        return result;
    }
}