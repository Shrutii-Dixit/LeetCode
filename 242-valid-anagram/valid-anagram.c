bool isAnagram(char* s, char* t) {
    int count[26]={0};
    //store
    for(int i=0; s[i]!='\0'; i++){
        count[s[i] - 'a']++;
    }

    //delete
    for(int i=0; t[i]!='\0'; i++){
        count[t[i] - 'a']--;
    }

    //count
    for(int i=0; i<26; i++){
        if(count[i] != 0){
            return false;
        }
    }
    return true;
}