package Message.dao;

import Message.domain.RoomInfo;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class RoomInfoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    //添加数据
    public RoomInfo insert(RoomInfo roomInfo) {
        return this.mongoTemplate.insert(roomInfo,"reserve");
    }

    //根据房间号模糊查询
    public List<RoomInfo> queryNumber(RoomInfo roomInfo) {
        Pattern pattern = Pattern.compile("^.*"+roomInfo.getRoomNumber()+".*$", Pattern.CASE_INSENSITIVE);
        Query query = Query.query(Criteria.where("roomNumber").regex(pattern));
        return this.mongoTemplate.find(query, RoomInfo.class,"reserve");
    }

    //根据类型查询
    public List<RoomInfo> queryRoomListByType(String type) {
        Query query = Query.query(Criteria.where("type").is(type));
        return this.mongoTemplate.find(query, RoomInfo.class,"reserve");
    }
    //查询所有信息
    public List<RoomInfo> sellAll() {
        List<RoomInfo> all = this.mongoTemplate.findAll(RoomInfo.class,"reserve");
        System.out.println("到这了"+all);
        return all;
    }

    //查询id查询
    public RoomInfo findOne(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        return this.mongoTemplate.findOne(query,RoomInfo.class,"reserve");
    }

    //根据id修改房间号
    public UpdateResult update(RoomInfo roomInfo) {
        Query query = Query.query(Criteria.where("_id").is(roomInfo.getId()));
        Update update = Update.update("age", roomInfo.getRoomNumber());
        return this.mongoTemplate.updateFirst(query, update, RoomInfo.class,"reserve");
    }

    //修改数据
    public RoomInfo saveRoomInfo(RoomInfo roomInfo) {
        return this.mongoTemplate.save(roomInfo,"reserve");
    }

    //根据文件id删除
    public DeleteResult deleteById(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        return this.mongoTemplate.remove(query, RoomInfo.class,"reserve");
    }

}