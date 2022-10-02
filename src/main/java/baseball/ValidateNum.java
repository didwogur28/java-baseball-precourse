package baseball;

import java.util.List;
import java.util.Set;

public class ValidateNum {

    StatusCode CODE = new StatusCode();

    public int numCheck(String arg) {

        int chgNum = 0;

        try {
            chgNum = Integer.parseInt(arg);
        } catch (Exception e) {
            throw new IllegalArgumentException(CODE.NOT_INTEGER_TYPE);
        }

        return chgNum;
    }

    public void sizeCheck(List<Integer> usrNumArr) {
        if(usrNumArr.size() != 3) {
            throw new IllegalArgumentException(CODE.ARRAY_SIZE_ERROR);
        }
    }

    public void containCheck(List<Integer> usrNumArr) {
        if(usrNumArr.contains(0)) {
            throw new IllegalArgumentException(CODE.ARRAY_CONTAIN_ERROR);
        }
    }

    public void dupCheck(List<Integer> usrNumArr, Set<Integer> chkDup) {

        if(usrNumArr.size() != chkDup.size()) {
            throw new IllegalArgumentException(CODE.ARRAY_DUP_ERROR);
        }
    }

}
