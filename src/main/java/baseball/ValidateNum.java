package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateNum {

    public void validateChk(List<Integer> usrNumArr) {

        Set<Integer> chkDup = new HashSet<>(usrNumArr);

        sizeCheck(usrNumArr);
        containCheck(usrNumArr);
        dupCheck(usrNumArr, chkDup);
    }

    public int numCheck(String arg) {

        int chgNum = 0;

        try {
            chgNum = Integer.parseInt(arg);
        } catch (Exception e) {
            throw new IllegalArgumentException(StatusCode.NOT_INTEGER_TYPE);
        }

        return chgNum;
    }

    public void sizeCheck(List<Integer> usrNumArr) {
        if(usrNumArr.size() != 3) {
            throw new IllegalArgumentException(StatusCode.ARRAY_SIZE_ERROR);
        }
    }

    public void containCheck(List<Integer> usrNumArr) {
        if(usrNumArr.contains(0)) {
            throw new IllegalArgumentException(StatusCode.ARRAY_CONTAIN_ERROR);
        }
    }

    public void dupCheck(List<Integer> usrNumArr, Set<Integer> chkDup) {

        if(usrNumArr.size() != chkDup.size()) {
            throw new IllegalArgumentException(StatusCode.ARRAY_DUP_ERROR);
        }
    }

}
