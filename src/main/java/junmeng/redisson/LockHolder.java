package junmeng.redisson;

/**
 * @author james
 * @date 2020/8/13
 */
public class LockHolder {

    private String lock;

    private String lockValue;

    public String getLock() {

        return lock;
    }

    public void setLock(String lock) {

        this.lock = lock;
    }

    public String getLockValue() {

        return lockValue;
    }

    public void setLockValue(String lockValue) {

        this.lockValue = lockValue;
    }

}
