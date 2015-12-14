(ns yourapp.system
  (:require [org.httpkit.server :refer [run-server]]
            [com.stuartsierra.component :as component]
            [yourapp.web]))
(defn- start-server [handler port]
  (let [server (run-server handler {:port port})]
    (println (str "Start server on localhost:" port))
    server))

(defn- stop-server [server]
  (when server
    (server)))

(defrecord App []
  component/Lifecycle
  (start [this]
    (assoc this :server (start-server #'yourapp.web/app 9009)))
  (stop [this]
    (stop-server (:server this))
    (dissoc this :server)))

(defn create-system []
  (App.))

(defn -main [& args]
  (.start (create-system)))
