package com.example.rpc.grpc;

import com.example.rpc.grpc.Service.NewsService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9999).addService(new NewsService()).build();
        server.start();
        server.awaitTermination();
    }
}
