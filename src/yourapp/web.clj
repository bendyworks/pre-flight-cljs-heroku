(ns yourapp.web
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [resources]]
            [ring.middleware.gzip :as gz]))

(defn- wrap-root-index [handler]
  (fn [req]
    (handler
     (update-in req [:uri]
                #(if (= "/" %)
                   "/index.html"
                   %)))))

(defroutes app
  (-> (resources "/")
      (wrap-root-index)
      (gz/wrap-gzip)))
