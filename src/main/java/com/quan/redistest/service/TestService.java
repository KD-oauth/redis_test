package com.quan.redistest.service;

import com.quan.redistest.entity.MkyAccessLog;
import com.quan.redistest.mapper.MkyAccessLogMapper;
import com.quan.redistest.util.IPUtil;
import com.quan.redistest.util.IdWorker;
import com.quan.redistest.utils.RedisUtils;
import freemarker.template.utility.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
@Transactional
@EnableScheduling
public class TestService {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private MkyAccessLogMapper mkyAccessLogMapper;

    public void saveUserActivity(HttpServletRequest request){
        //访问量
        String userAccount = (String)redisUtils.get("userAccount");
        if(userAccount==null){
            redisUtils.set("userAccount","1");
        }else{
            redisUtils.incr("userAccount",1);
        }
        //日活量
        String ip = IPUtil.getIpAddress(request);
        redisUtils.sSet("userLiveCount",ip);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    //@Scheduled(cron = "*/5 * * * * ?")
    public void saveUserAccessLog(){
        //访问量
        String userAccount = (String)redisUtils.get("userAccount");
        int num = Integer.parseInt(userAccount);
        MkyAccessLog mal = new MkyAccessLog();
        IdWorker iw = new IdWorker();
        String id = String.valueOf(iw.nextId());
        mal.setId(id);
        mal.setCount(num+"");
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String createDatetime = dateFormat.format(calendar.getTime());
        mal.setCreateDatetime(createDatetime);
        mal.setType("1");
        mal.setDelFlag("0");
        //保存当天访问量
        mkyAccessLogMapper.insert(mal);
        //将redis中的访问量初始化
        redisUtils.set("userAccount","0");
        //日活量
        long len = redisUtils.sGetSetSize("userLiveCount");
        MkyAccessLog mal1 = new MkyAccessLog();
        IdWorker iw1 = new IdWorker();
        String id1 = String.valueOf(iw1.nextId());
        mal1.setId(id1);
        mal1.setCount(len+"");
        mal1.setCreateDatetime(createDatetime);
        mal1.setType("2");
        mal1.setDelFlag("0");
        //保存当天日活量
        mkyAccessLogMapper.insert(mal1);
        //设置缓存时间为1秒，变向清除set
        redisUtils.expire("userLiveCount",1);
    }

    public int add2(int a,int b){
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        return a+b;
    }

    public int add(int a,int b){
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");
        sb.append("1");



        return a+b;
    }

}
