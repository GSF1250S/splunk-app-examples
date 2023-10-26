/*
 * Copyright 2023 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


public class Program {
    public static void main(String[] args) {
        Command command = Command.splunk("info").parse(args);
        String filePath = "<Path to SSL Certificate.pem fiel>";
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        Service service = Service.connect(command.opts);

        ServiceInfo info = service.getInfo();
        System.out.println("Info:");
        for (Map.Entry<String, Object> entry : info.entrySet())
            System.out.println("    " + entry.getKey() + ": " + entry.getValue());

        Entity settings = service.getSettings();
        System.out.println("\nSettings:");
        for (Map.Entry<String, Object> entry : settings.entrySet())
            System.out.println("    " + entry.getKey() + ": " + entry.getValue());
    }
}