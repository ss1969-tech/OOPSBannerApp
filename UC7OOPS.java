public class UC7OOPS {

    /**
     * CharacterPatternMap – Inner class for storing character-to-pattern mappings
     */
    static class CharacterPatternMap {
        Character character;
        String[] pattern;

        
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        
        public Character getCharacter() {
            return character;
        }

       
        public String[] getPattern() {
            return pattern;
        }
    }

    
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        CharacterPatternMap[] maps = new CharacterPatternMap[4];

        String[] O = {
                " *** ",
                "*   *",
                "*   *",
                "*   *",
                "*   *",
                "*   *",
                " *** "
        };

        String[] P = {
                "**** ",
                "*   *",
                "*   *",
                "**** ",
                "*    ",
                "*    ",
                "*    "
        };

        String[] S = {
                " ****",
                "*    ",
                "*    ",
                " *** ",
                "    *",
                "    *",
                "**** "
        };

        String[] space = {
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     "
        };

        maps[0] = new CharacterPatternMap('O', O);
        maps[1] = new CharacterPatternMap('P', P);
        maps[2] = new CharacterPatternMap('S', S);
        maps[3] = new CharacterPatternMap(' ', space);

        return maps;
    }

   
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] maps) {

        for (CharacterPatternMap map : maps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }

        
        return maps[3].getPattern();
    }

    
    public static void printMessage(String message, CharacterPatternMap[] maps) {

        int height = 7;

        for (int i = 0; i < height; i++) {

            StringBuilder line = new StringBuilder();

            for (char ch : message.toCharArray()) {

                String[] pattern = getCharacterPattern(ch, maps);
                line.append(pattern[i]).append("  ");
            }

            System.out.println(line);
        }
    }

    
    public static void main(String[] args) {

        CharacterPatternMap[] charMaps = createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, charMaps);
    }
}