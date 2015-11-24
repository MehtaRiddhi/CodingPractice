#!/bin/bash
mvn package
java -Xmx1G -cp target/leetcode-1.0-SNAPSHOT.jar com.gmail.theandriicherniak.leetcode.Main
