package Message.Service;

import Message.domain.RoomInfo;
import com.mongodb.client.result.DeleteResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomInfoService {
    /**
     * 查询所有房间信息
     * @return
     */
//    List<RoomInfo> selAllRoomInfo();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    RoomInfo selById(String id);

    /**
     * 查询所有
     * @return
     */
    List<RoomInfo> selAll();

    /**
     * 根据创建者id查询
     * @param orgId
     * @return
     */
//    List<RoomInfo> selByOrgId(int orgId);

    /**
     * 添加数据
     * @param roomInfo
     * @return
     */
    RoomInfo insert(RoomInfo roomInfo);

    /**
     * 文件删除
     * @param roomInfo
     * @return
     */
    DeleteResult del(RoomInfo roomInfo);

    /**
     * 修改数据
     * @param roomInfo
     * @return
     */
    RoomInfo updInfo(RoomInfo roomInfo);

}
