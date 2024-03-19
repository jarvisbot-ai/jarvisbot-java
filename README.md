# JarvisBot Java API library

## Access Token
> [!IMPORTANT]
> JarvisBot SDK is currently undergoing rapid development, which may lead to stability and compatibility issues. You can email support@jarvisbot.ai to request an access token. We will periodically open up trials.

# How to Use

### The sample way to use

```java
import com.jarvisbot.sdk.JarvisBot;
import base.com.jarvisbot.sdk.IJarvisBot;
import res.entity.com.jarvisbot.sdk.ChatRes;

try{
IJarvisBot jarvisBot = new JarvisBot("you token").baseBlock();
ChatRes result = jarvisBot.chat(Chat.defaultChat("hi")).blockingGet();
    System.out.

println(result);
}catch(
Exception exception){
        // TODO: created failed or chat failed
        }
```

## 1. create `JarvisBot` by you token

+ create default

```java
import com.jarvisbot.sdk.JarvisBot;

JarvisBot jarvisBot = new JarvisBot("you token");
```

+ Create with custom `ExecutorService`

```java
import com.jarvisbot.sdk.JarvisBot;

JarvisBot jarvisBot = new JarvisBot("you token", customExecutorService);
```

+ Or you can get error when `JarvisBot` create failed

```java
import com.jarvisbot.sdk.JarvisBot;
import interfaces.common.com.jarvisbot.sdk.I1;

I1<Throwable> errorCallback = System.out::println;
JarvisBot jarvisBot = new JarvisBot("you token", errorCallback);
JarvisBot jarvisBot = new JarvisBot("you token", customExecutorService, errorCallback);
```

## 2. use `base` or `baseBlock`

if you use `base` , you may be got `null` or `Error` when the `JarvisBot` have not been created or created failed

if you use `baseBlock` , you may be blocked because `JarvisBot` have not been created or throw an exception when created failed

```java
   JarvisBot jarvisBot =  jarvisBot.base();
   JarvisBot jarvisBot =  jarvisBot.baseBlock();
```

## 3. chat
you can default to chat or custom your param `ChatReq`.

Also, you can get result by block current thread or asynchronous execution
```java
ChatReq chatReq = Chat.defaultChat("");
// TODO chatReq.set...
JarvisFuture<ChatRes> future = jarvisBot.chat(chatReq);
future.blockingGet();
// or
future.async(new Consumer<ChatRes>{
    @Override
    public void apply(ChatRes param) {
        // handle param
    }

//    @Override
//    public void onError(Throwable e) {
//    do something
//    }

//    @Override
//    public void completed() {
//    do something
//    }
})
```

## 4.txt2img

```java
Txt2imgReq req = Txt2Img.default2Img("");
// TODO req.set...
JarvisFuture<ImgRes> future = jarvisBot.txt2img(req);
//future.blockingGet();
// or
//future.async(new Consumer<ImgRes>{/*...*/})
```

## 5.img2img

```java
Img2imgReq req = Img2Img.default2Img("",/*list of `img_url` or `img_base64_string`*/);
// TODO req.set...
JarvisFuture<ImgRes> future = jarvisBot.img2img(req);
//future.blockingGet();
// or
//future.async(new Consumer<ImgRes>{/*...*/})
```


## 6.tts

```java
TtsReq req = Tts.defaultTts("some words");
// TODO req.set...
// mp3 raw data
JarvisFuture<byte[]> future = jarvisBot.tts(req);
//future.blockingGet();
// or
//future.async(new Consumer<ImgRes>{/*...*/})
```



## 7.chat by sse

**observeBlock** can block current thread

```java
import observe.common.com.jarvisbot.sdk.Observer;

ChatReq req = Chat.defaultChat("");
// TODO chatReq.set...
Observer<ChatRes> future = jarvisBot.chatSee(req);
//future.observe(new Consumer<ChatRes>() {/*...*/})
//future.observeBlock(new Consumer<ChatRes>() {/*...*/})
```

## 8.asr

```java
AsrReq req = Asr.defaultAsr(/*base64 string, mp3 raw data*/);
// TODO req.set...
JarvisFuture<AsrRes> future = jarvisBot.asr(req);
//future.blockingGet();
// or
//future.async(new Consumer<AsrRes>{/*...*/})
```
