package com.example.rpc.grpc.Service;


import com.example.rpc.grpc.proto.NewsProto;
import com.example.rpc.grpc.proto.NewsServiceGrpc;
import io.grpc.stub.StreamObserver;

public class NewsService extends NewsServiceGrpc.NewsServiceImplBase {
    @Override
    public void list(NewsProto.NewsRequest request, StreamObserver<NewsProto.NewsResponse> responseObserver) {
        String date = request.getDate();
        NewsProto.NewsResponse newsList= null;

        try {
            NewsProto.NewsResponse.Builder newsBuilder = NewsProto.NewsResponse.newBuilder();
            for (int i = 0 ; i<= 100 ; i++){
                NewsProto.News news = NewsProto.News.newBuilder().setId(i)
                        .setContent(date+"当前新闻新闻"+i)
                        .setTitle("新闻标题"+i)
                        .setCreateTime(System.currentTimeMillis())
                        .build();
                newsBuilder.addNews(news);
            }
        } catch (Exception e) {
            responseObserver.onError(e);
        }finally {
            responseObserver.onNext(newsList);
        }
        responseObserver.onCompleted();
    }
}
