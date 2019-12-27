package per.liam.stumanager.model;

import per.liam.stumanager.dao.ResultDao;
import per.liam.stumanager.dao.ResultDaoImpl;

import static per.liam.stumanager.model.MainFrameInit.delStu;

/**
 * @author liam
 * @date 19-12-19 上午11:04
 */
public class Delete {
    public int delete(){
        ResultDao resultDao = new ResultDaoImpl();
        return resultDao.delStu(delStu.get(0).getSno());
    }
}
