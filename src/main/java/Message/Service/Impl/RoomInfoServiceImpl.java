package Message.Service.Impl;

import Message.Service.RoomInfoService;
import Message.dao.RoomInfoDao;
import Message.domain.RoomInfo;
import com.mongodb.client.result.DeleteResult;
import com.spc.base.error.ReserveErrorCodeEnum;
import com.spc.base.exceptions.SpcCloudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomInfoServiceImpl implements RoomInfoService {
    @Autowired
    private RoomInfoDao roomInfoDao;
    //根据id查询
    @Override
    public RoomInfo selById(String id) {
        return roomInfoDao.findOne(id);
    }
    //查询所有
    @Override
    public List<RoomInfo> selAll() {
        return roomInfoDao.sellAll();
    }
    //添加数据
    @Override
    public RoomInfo insert(RoomInfo roomInfo) {
        return roomInfoDao.insert(roomInfo);
    }
    //根据文件id删除
    @Override
    public DeleteResult del(RoomInfo roomInfo) {
        return roomInfoDao.deleteById(roomInfo.getId());
    }
    //更新数据
    @Override
    public RoomInfo updInfo(RoomInfo roomInfo) {
        RoomInfo one = roomInfoDao.findOne(roomInfo.getId());
        if (one==null){
            throw new SpcCloudException(ReserveErrorCodeEnum.RL10020001,roomInfo.getId());
        }else{
            //合并数据
            //怎么说
            return  roomInfoDao.saveRoomInfo(roomInfo);
        }

    }
}
