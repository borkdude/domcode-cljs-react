(defproject animals-crud "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3211"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-jetty-adapter "1.3.2"]               
                 [org.webjars/bootstrap "3.2.0"]
                 [cljs-http "0.1.30"]
                 [compojure "1.3.4"]
                 [liberator "0.13"]
                 [fogus/ring-edn "0.2.0"]
                 [clj-json "0.5.3"]
                 [reagent "0.5.0"]]

  :plugins [[lein-ring "0.9.1"]
            [lein-cljsbuild "1.0.5"]]

  :clean-targets ^{:protect false} [:target-path :compile-path "resources/public/out"]

  :source-paths ["src"]

  :profiles {:dev {:repl-options {:init-ns animals.api}
                   :plugins [[lein-figwheel "0.3.1"]]
                   :figwheel {:http-server-root "public"
                              :port 3449 }}}

  :cljsbuild {:builds [{:id "reagent"
                        :source-paths ["src-cljs"]
                        :figwheel true
                        :compiler {:output-to "resources/public/crud.js"
                                   :output-dir "resources/public/out"
                                   :optimizations :none
                                   :asset-path "out"
                                   :main "animals.crud"
                                   :source-map true}}]}

  :ring {:handler animals.api/handler
         :nrepl {:start? true :port 4500}
         :port 8090
         :init animals.api/init}
  :global-vars {*print-length* 20})
