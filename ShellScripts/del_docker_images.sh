# This code is for deleting the docker images which have the name <none>
#!/bin/bash

dockerImages=($(docker images | grep -i none | awk '{print $3}'))

for i in ${dockerImages[@]}
do
        docker rmi -f $i
done
