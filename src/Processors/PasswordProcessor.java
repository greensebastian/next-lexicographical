package Processors;

import Interface.IProcessor;

public class PasswordProcessor implements IProcessor {
    @Override
    public String Run(String input) {

        // TODO fix length = 1/0

        String right = "";
        String left = "";
        char middle = (char) 0;

        for (int i = input.length() - 1; i > 0; i--) {
            char prev = input.charAt(i);
            char next = input.charAt(i-1);
            if (next < prev){ // Tipping point found
                middle = next;
                right = input.substring(i);
                left = input.substring(0, i - 1);
                break;
            }
            if (i == 1){
                return "No Answer";
            }
        }

        StringBuilder outputSb = new StringBuilder();
        outputSb.append(left);

        boolean middleAdded = false;

        if (right.length() > 0){
            outputSb.append(right.charAt(right.length()-1));
        }

        for (int i = right.length()-2; i >= 0; i--){
            char current = right.charAt(i);

            if (middle > current && !middleAdded){
                outputSb.append(right);
                outputSb.append(middle);
                middleAdded = true;
                break;
            }

            else if (middle <= current && !middleAdded){
                outputSb.append(middle);
                middleAdded = true;
            }

            outputSb.append(current);
        }

        if (!middleAdded){
            outputSb.append(middle);
        }

        String output = outputSb.toString();

        return output;
    }
}
