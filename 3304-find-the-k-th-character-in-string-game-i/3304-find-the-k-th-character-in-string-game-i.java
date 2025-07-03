public char findKthCharacter(int k) {
    // convert the 1-based 'k' to a 0-based index
    int index = k - 1;

    // calculate the number of set bits
    // this will be the total number of times the character has been incremented
    int increments = 0;
        
    while (index > 0) {
       
        while (p * 2 <= index) {
            p *= 2;
        }


        increments++;

        index -= p;
    }
        

    return (char) ('a' + (increments % 26));