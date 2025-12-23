public class Dictionary {
    private final Letter [] dictionary;
    private boolean flag = true;

    @Override
    public String toString() {
        String answer = "";
        for (int i = 0; i < this.dictionary.length; i++) {
            Letter currentLetter = this.dictionary[i];

            if (currentLetter.getCount() != 0) {
                if (this.flag) {
                    for (int j = 0; j < currentLetter.getCount(); j++) {
                        answer += currentLetter.getSymbol();
                    }

                    answer += ' ';
                }

                else {
                    answer += currentLetter.getSymbol() + "-" + currentLetter.getCount() + "; ";
                }
            }
        }

        return answer;
    }

    public Dictionary() {
        this.dictionary = new Letter[33 + 26];

        for (int i = 0; i < 26; i++) {
            this.dictionary[i] = new Letter((char) ('a' + i), 0);
        }

        for (int i = 0; i < 33; i++) {
            this.dictionary[26 + i] = new Letter((char) ('а' + i), 0);
        }
    }

    public Letter [] getDictionary() {
        return this.dictionary;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    static int find_index(char letter) {
        int index;
        if (letter <= 'z') {
            index = letter - 'a';
        }

        else {
            index = letter - 'а' + 26;
        }

        return index;
    }

    static char lower(char letter) {
        if (('A' <= letter && letter <= 'Z') || ('А' <= letter && letter <= 'Я')) {
            if (letter <= 'Z') {
                letter = (char) ('a' + letter - 'A');
            }

            else {
                letter = (char) ('а' + letter - 'А');
            }
        }

        return letter;
    }

    public void addLetter(String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = lower(word.charAt(i));
            if (('a' <= letter && letter <= 'z') || ('а' <= letter && letter <= 'я')) {
                int index = find_index(letter);
                this.dictionary[index].increaseCount();
            }
        }
    }

    public int countOfLetter(char letter) {
        if (('a' <= letter && letter <= 'z') || ('а' <= letter && letter <= 'я')) {
            int index = find_index(letter);

            return this.dictionary[index].getCount();
        }

        return 0;
    }

    public int totalAmount() {
        int answer = 0;
        for (int i = 0; i < this.dictionary.length; i++) {
            answer += this.dictionary[i].getCount();
        }

        return answer;
    }

    public String negativePossibleWord(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = lower(word.charAt(i));

            if (('a' <= letter && letter <= 'z') || ('а' <= letter && letter <= 'я')) {
                int index = find_index(letter);
                if (this.dictionary[index].getCount() != 0) {
                    answer += letter;
                    this.dictionary[index].decreaseCount();
                }
            }
        }

        return answer;
    }

    public boolean isWordPossible(String word) {
        Dictionary checkingDictionary = new Dictionary();
        checkingDictionary.addLetter(word);
        Letter [] dictionaryOfChecking = checkingDictionary.getDictionary();

        for (int i = 0; i < dictionaryOfChecking.length; i++) {
            if (this.dictionary[i].getCount() < dictionaryOfChecking[i].getCount()) {
                return false;
            }
        }
        return true;
    }

    public String positivePossibleWord(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = lower(word.charAt(i));

            if (('a' <= letter && letter <= 'z') || ('а' <= letter && letter <= 'я')) {
                int index = find_index(letter);
                if (this.dictionary[index].getCount() != 0) {
                    answer += letter;
                }
            }
        }

        return answer;
    }

    public String fullWord(String word) {
        String answer = "";

        if (isWordPossible(word)) {
            for (int i = 0; i < word.length(); i++) {
                char letter = lower(word.charAt(i));

                if (('a' <= letter && letter <= 'z') || ('а' <= letter && letter <= 'я')) {
                    int index = find_index(letter);

                    this.dictionary[index].decreaseCount();
                }

                else {
                    return "";
                }
            }

            answer = word;
        }

        return answer;
    }

    public int numberPossibleWords(String word) {
        if (!word.isEmpty()) {
            Dictionary checkingDictionary = new Dictionary();
            checkingDictionary.addLetter(word);
            Letter [] dictionaryOfChecking = checkingDictionary.getDictionary();

            if (isWordPossible(word)) {
                int count = this.dictionary[find_index(lower(word.charAt(0)))].getCount() / dictionaryOfChecking[find_index(lower(word.charAt(0)))].getCount();
                for (int i = 1; i < word.length(); i++) {
                    char letter = lower(word.charAt(i));
                    int index = find_index(letter);

                    if (this.dictionary[index].getCount() / dictionaryOfChecking[index].getCount() < count) {
                        count = this.dictionary[index].getCount() / dictionaryOfChecking[index].getCount();
                    }
                }

                return count;
            }
        }

        return 0;
    }
}
