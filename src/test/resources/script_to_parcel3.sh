cp "/users/username/applications/jars/MyRemoteApp.jar" "archive_0" && \

current_dir=$(pwd) && \
cd "archive_1" && \
unzip "../archive_0/MyRemoteApp.jar" "nested/folder/Inner.zip" && \
cd "$current_dir" && \

current_dir=$(pwd) && \
cd "files" && \
zip -o "../archive_1/nested/folder/Inner.zip" "com/example/App.class" \
      "com/example/util/Util.class" && \
cd "$current_dir" && \

current_dir=$(pwd) && \
cd "archive_1" && \
zip -o "../archive_0/MyRemoteApp.jar" "nested/folder/Inner.zip" && \
cd "$current_dir" && \

cd "archive_0" && \
mv "/users/username/applications/jars/MyRemoteApp.jar" \
  "/users/username/applications/jars/MyRemoteApp.jar-bk" && \
mv "archive_0/MyRemoteApp.jar" "/users/username/applications/jars/MyRemoteApp.jar"