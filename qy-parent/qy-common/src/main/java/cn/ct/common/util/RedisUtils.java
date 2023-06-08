package cn.ct.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<String , Object> redisTemplate;

    /**
     * 普通缓存放入
     */
    public boolean set(String key, Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 写入缓存并指定时间
     */
    public boolean set(String key,Object value,Long times){
        try {
            redisTemplate.opsForValue().set(key,value,times, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 判断缓存中是否有该键
     * @param key
     * @return
     */
    public boolean exists(String key){
         return redisTemplate.hasKey(key);
    }

    /**
     * 普通缓存获取
     * @param key
     * @return
     */
   public Object get(String key){
       Object result = null;
       //此接口定义了怎样操作Redis简单值  调用.set可以将指定的K-V写入Redis  调用.get可以从Redis中获取指定的值
       ValueOperations<String, Object> operations = redisTemplate.opsForValue();
       result = operations.get(key);
       return result;
   }

    /**
     * 指定缓存失效时间
     * @param key
     * @param time
     * @return
     */
   public boolean expire(String key,Long time){
         try {
             if (time > 0){
                 redisTemplate.expire(key,time,TimeUnit.SECONDS);
             }
             return true;
         }catch (Exception e){
              e.printStackTrace();
              return false;
         }
   }

    /**
     * 根据key获取过期时间
     *
     * @param key
     * @return
     */
   public long getExpire(String key){
       return redisTemplate.getExpire(key,TimeUnit.SECONDS);
   }

    /**
     * 递增
     * @param key
     * @param delta
     * @return
     */
   public long incr(String key,long delta){
         if (delta<0){
             System.out.println("递增数要大于一");
         }
         return redisTemplate.opsForValue().increment(key,delta) ;
   }

    /**
     * 递减
     * @param key
     * @param delta
     * @return
     */
   public long decr(String key,long delta){
       if (delta<0){
           System.out.println("递减数要大于1");
       }
       return redisTemplate.opsForValue().decrement(key,delta);
   }

    /**
     * 删除单个
     * @param key
     */
   public void del(String... key){
       if (key != null){
           redisTemplate.delete(Arrays.asList(key));
       }
   }

   public void get(){

   }
}
