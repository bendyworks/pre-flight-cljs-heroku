(defproject yourapp "0.1.0-SNAPSHOT"
  :description "Your app, remember to replace `yourapp' with your stuff."
  :url ""
  :license  {:name "Eclipse Public License"
             :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main yourapp.system
  :min-lein-version "2.0.0"
  :uberjar-name "yourapp.jar"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.145"]
                 [http-kit "2.1.18"]
                 [compojure "1.4.0"]
                 [com.stuartsierra/component "0.2.3"]
                 [environ "1.0.1"]
                 [bk/ring-gzip "0.1.1"]]
  :plugins [[lein-cljsbuild "1.1.1-SNAPSHOT"]]
  :profiles {:uberjar {:source-paths ["env/prod/clj"]
                       :hooks [leiningen.cljsbuild]
                       :env {:production true}
                       :aot :all
                       :main ripple.system
                       :cljsbuild {:builds {:app
                                            {:source-paths ["env/prod/cljs"]
                                             :compiler {:optimizations :advanced
                                                        :pretty-print false}}}}}
             :dev {:plugins [[lein-figwheel "0.4.1"]]
                   :dependencies [[reloaded.repl "0.1.0"]]
                   :source-paths ["dev"]
                   :cljsbuild {:builds [{:source-paths ["src" "dev"]
                                         :figwheel :true
                                         :compiler {:output-to "target/classes/public/app.js"
                                                    :output-dir "target/classes/public/out"
                                                    :main "yourapp.view"
                                                    :asset-path "/out"
                                                    :optimizations :none
                                                    :recompile-dependents true
                                                    :source-map true}}]}}})
