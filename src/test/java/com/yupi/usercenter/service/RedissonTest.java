package com.yupi.usercenter.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.usercenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.yupi.usercenter.contant.UserConstant.PRECACHEJOB;

@SpringBootTest
public class RedissonTest {

    @Autowired
    private RedissonClient redissonClient;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        List<String> list = new ArrayList<>();
        list.add("yupi");
        System.out.println("list:" + list.get(0));
        list.remove(0);

        RList<String> rList = redissonClient.getList("test-list");
        rList.add("yupi");
        System.out.println("rlist:" + rList.get(0));
    }

    @Test
    void testWatchDog() {
        RLock lock = redissonClient.getLock(PRECACHEJOB);
        try {
            // 只有一个线程能获取到锁
            if (lock.tryLock(0,30000L, TimeUnit.MILLISECONDS)){
                System.out.println("getLock" + Thread.currentThread().getId());
            }
        } catch (InterruptedException e) {
            System.out.println("doCacheRecommendUser error");
        } finally {
            // 只能释放自己的锁
            if (lock.isHeldByCurrentThread()) {
                System.out.println("unLock" + Thread.currentThread().getId());
                lock.unlock();
            }
        }
    }
}
