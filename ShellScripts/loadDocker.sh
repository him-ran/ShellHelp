#!/bin/bash
# This shell script is to load the docker images as tar files at a particular location on the machine.

# Parameter Check.
if [ $# -lt 1 ]
then
        echo "[ERROR]: Please provide a path to load te docker tar files."
        exit -1
fi

# Variable assigning.
directory=$1

# Loading the filenames in an array.
dockerimages=($( ls -l $directory | grep -i tar | awk '{print $9}'))

# Loading the docker images.
for i in ${dockerimages[@]}
do
        docker load -i $i
done
